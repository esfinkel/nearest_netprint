# nearest_netprint.py
# by Elisabeth Finkel (finkelelisabeth@gmail.com ; esf76@cornell.edu)
# written May 28, 2018
# last modified May 28, 2018
# free for personal use/distribution, ideally with these credits intact

'''
When run on command line, prints a list of the nearest netprint-enabled printers offered by Cornell.
    -You can specify type of printer with argvs 'color' or 'bw'.
    -If you do not specify, you will receive lists for both.
    -You will then be prompted for GPS coordinates.
        -You can use argv 'auto' for your GPS location to be computed automatically.
        -Precision of automatic computations is poor at best.
As a courtesy, I've left my access key in the code (toward the bottom, variable name `key`).
    -If you're doing more than a handful of requests, please, please, get your own.
    -You can get one for free at https://ipstack.com/product
Requires internet access.
Note that, as building hours have not yet been inputted, printers suggested to you may be in buildings that are closed.
    -Building hours can typically be manually checked via Google Maps or departmental websites.
    -If anyone knows an API/program for that, let me know. Or try it yourself.
Note also that, as most of the coordinates were extracted from another API, some of them are likely wrong.
    -Feel free to correct those errors as they arise.
'''


import requests
import json
from math import radians, cos, sin, asin, sqrt


# for each printer, store (0: name, 1: text-form location, 2: bw or color info, 3: decimal latitude, 4: decimal longitude, 5: will add schedule)

############################

printers_bw = [
    
    ['aap-nyc-1bw','NYTech','campus-bw, campus-color','40.7558','-73.9562'],
    ['aap-sib-1bw','Sibley Hall - 3rd Floor Lab (Barclay Jones)','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['aap-sib-3bw','Sibley Hall - 2nd Floor Lab (ADMS)','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['aap-sib-4bw','Sibley Hall - 3rd Floor Balcony (inside dome)','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['aap-tjaden-1bw','Tjaden Hall - Darkroom','campus-bw, campus-color','42.4509025','-76.4853131'],
    ['afr-lib1','Africana Library','campus-bw, campus-color','42.4573916','-76.4822137'],
    ['appel1','Appel Commons Community Center - 1st Floor','campus-bw','42.45592449999999','-76.4774412'],
    ['becker-nprint1','Becker House - Room G39 - Computer Lab - North wing - Ground floor','campus-bw','42.448204','-76.4894583'],
    ['becker-nprint2','Becker House - Computer lab - North wing - Ground floor Room# G39','campus-bw','42.448204','-76.4894583'],
    ['bin1','Statler Hall 365 - by the lab monitor desk - fourth from window','campus-bw','42.4454727','-76.48206789999999'],
    ['bin2','Statler Hall 365 - by the lab monitor desk - third from window','campus-bw','42.4454727','-76.48206789999999'],
    ['bin3','Statler Hall 365 - by the lab monitor desk - second from window','campus-bw','42.4454727','-76.48206789999999'],
    ['catherwood-lnge','Catherwood Library - 136 Ives Hall - First Floor Lounge','campus-bw, campus-color','42.4472562','-76.4811158'],
    ['catherwood-np1/catherwood-np2/catherwood-np3','Catherwood Library - 236 Ives Hall - Reference Area','campus-bw, campus-color','42.4472562','-76.4811158'],
    ['cisuglab','Gates Hall - Room G33','campus-bw','42.4449769','-76.4810912'],
    ['cit-carp-1bw/cit-carp-3bw','Carpenter Hall Computer Lab - Main Floor','campus-bw, campus-color','42.4856319','-76.4663403'],
    ['cit-carp-4bw/cit-carp-5bw','Carpenter Hall Computer Lab - Second Floor Hallway','campus-bw, campus-color','42.4856319','-76.4663403'],
    ['cit-mann220a-1bw/cit-mann220a-2bw','Mann Library Computer Lab - Room 220A - Second Floor','campus-bw, campus-color','42.448766','-76.4763118'],
    ['cit-ph318-1bw/cit-ph318-2bw','Phillips Hall Computer Lab - Room 318','campus-bw, campus-color','42.4445768','-76.4820529'],
    ['cit-rpcc-1bw/cit-rpcc-2bw','Robert Purcell Community Center - RPCC - Computer Lab - Room 207','campus-bw, campus-color','42.4562967','-76.4783146'],
    ['cit-surge-1bw','Ag Quad - Academic Surge B - Room 159','campus-bw, campus-color','42.4488081','-76.4780298'],
    ['cit-upson-1bw/cit-upson-2bw','Upson Hall - Room 225','campus-bw, campus-color','42.4439852','-76.4828736'],
    ['cit-uris-1bw/cit-uris-2bw','Uris Library - Tower Room Computer Lab - Downstairs from Entrance','campus-bw, campus-color','42.447905','-76.484293'],
    ['cit-uris-3bw','Uris Library - Electronic Classroom - Room B05','campus-bw, campus-color','42.447905','-76.484293'],
    ['cit-wsh-1bw/cit-wsh-2bw','Willard Straight Hall - Computer Lab - Basement Level','campus-bw, campus-color','42.4465919','-76.4856765'],
    ['ciw2','District of Columbia - Cornell in Washington','campus-bw, campus-color','42.4358405','-76.493497'],
    ['cook-nprint1','Alice Cook House - Computer Lab','campus-bw','42.4489805','-76.4896109'],
    ['dss-mps-lab1','MPS Statistics computing lab room Mallot 301A - card reader door access for MPS students only','campus-bw','42.4479101','-76.4800518'],
    ['gs1','Goldwin Smith Hall - Room 338','campus-bw','42.44907329999999','-76.4835344'],
    ['gs3','Goldwin Smith Hall – Room 213','campus-bw','42.44907329999999','-76.4835344'],
    ['hollister1','Hollister 202 CEE Undergrad Lounge','campus-bw','42.4443332','-76.4847092'],
    ['house5','Rose House - Computer Lab - Room# 110','campus-bw','42.4477928','-76.4888006'],
    ['ilr-lab1/ilr-lab2','Ives Hall - Room 118 - Computer Lab','campus-bw, campus-color','42.4472571','-76.4811162'],
    ['keeton-nprint1','Keeton House - Room 151 - Computer Lab','campus-bw','42.4467158','-76.4894902'],
    ['kroch-lib1','Kroch Library - 1st floor Asia reading room','campus-bw, campus-color','42.4477741','-76.4841596'],
    ['laprinter2','Kennedy Hall - Room 467','campus-bw','42.4482603','-76.4793974'],
    ['law-lib1','Law Library - 3rd floor','campus-bw','42.4438549','-76.48577239999997'],
    ['mann1/mann2/mann3','Mann Library - First Floor','campus-bw, campus-color','42.4487577','-76.47631179999999'],
    ['mann6','Mann Library - 2nd Floor','campus-bw, campus-color','42.448766','-76.47631179999999'],
    ['math-lib2','Mallott Hall - Math Library - Fourth Floor','campus-bw','42.4482224','-76.4802083'],
    ['mcfaddin1/mcfaddin2','McFaddin - Room G22 - Computer Lab','campus-bw','42.447337', '-76.487931'],
    ['morrison-1','Morrison Hall - Animal Science Undergraduate Student Lounge - Room 140','campus-bw','42.446309','-76.469368'],
    ['mseugrad','Bard Lab 247','campus-bw','42.4439614','-76.5018807'],
    ['mth-372/mth-373/mth-374/mth-375','Myron Taylor Hall 2nd Floor Computer Lab','campus-bw','42.444460','-76.486113'],
    ['mth-ilj','Myron Taylor Hall International Law Journal Office','campus-bw','42.444460','-76.486113'],
    ['mth-jlpp','Myron Taylor Hall Journal Law and Public Policy Office','campus-bw','42.444460','-76.486113'],
    ['mth-lawreview','Myron Taylor Hall Law Review Office','campus-bw','42.444460','-76.486113'],
    ['mth-studentorg','Myron Taylor Hall Student Organizations Office','campus-bw','42.444460','-76.486113'],
    ['music-lib1','Music Library - 3rd floor Lincoln Hall','campus-bw, campus-color','42.4501817','-76.4833675'],
    ['olin-lib1/olin-lib2/olin-lib3/olin-lib4','Olin Library - behind the reference desk','campus-bw, campus-color','42.447905','-76.484293'],
    ['olin-lib6','Olin Library - B12','campus-bw, campus-color','42.447905','-76.484293'],
    ['olin-lib7','Olin Library - 5th floor Grad Study','campus-bw, campus-color','42.447905','-76.484293'],
    ['orie-netprint2/orie-netprint3','Rhodes Hall - Room 453','campus-bw',42.4433613,-76.4812668],
    ['physci-lib1','Clark Hall - Physical Sciences Library','campus-bw, campus-color','42.4497606','-76.4812001'],
    ['sage-205/sage-205-bw2','Sage Hall - Room 205 Suite - Next to Dean\'s Office','campus-bw, campus-color','42.4458918','-76.4833009'],
    ['sage-301-bw','Sage Hall Library - Room 301 - Third Floor Collaboration Space','campus-bw, campus-color','42.4458947','-76.4832581'],
    ['sage-basement-a/sage-basement-b','Sage Hall - Basement - Near Student Mailboxes','campus-bw','42.4458918','-76.4833009'],
    ['sage-lib1-bw/sage-lib2-bw','Sage Hall - Library - First Floor','campus-bw','42.4458918','-76.4833009'],
    ['schwartz1','Schwartz Center - Second Floor - Near elevator','campus-bw',42.4424328,-76.4859273],
    ['sha-grad1','Statler Hall G0032','campus-bw',42.4668288,-76.4851556],
    ['sha-mslc-front1/sha-mslc-front2/sha-mslc-front3','Nestle Library - west side of reference desk','campus-bw',42.446092,-76.4815932],
    ['sha-mslc-lounge','Statler Hall Ground Floor Student Lounge - North side of room','campus-bw',42.4668288,-76.4851556],
    ['sha-mslc-quick','Nestle Library - by the standup "Quick Print" stations','campus-bw',42.446092,-76.4815932],
    ['snee-netprint1','Snee Hall Student Lounge','campus-bw','42.443653','-76.484938'],
    ['tatkon1','South Balch Hall - Tatkon Center - Front Desk','campus-bw','42.453212','-76.479392'],
    ['uris-lib1','Uris Library - In Front of Circulation Desk','campus-bw, campus-color','42.447905','-76.484293'],
    ['uris-lib3','Uris Library - Austen Room','campus-bw, campus-color','42.447905','-76.484293'],
    ['uris-lib5','Uris Library - CL3 Lab','campus-bw, campus-color','42.447905','-76.484293'],
    ['vetlib2','Schurman Hall - S1201','campus-color','42.4480179','-76.4661765'],
    ['vetlib3','Schurman Hall - S1201','campus-bw','42.4480179','-76.4661765'],
    ['vm-bilinski-01','Bilinski Lab','campus-bw','42.4799809','-76.4511259'],
    ['vm-wiswall-01/vm-wiswall-02','Wiswall Lab','campus-bw','42.4799809','-76.4511259'],
    ['whitelab','White Hall - Room B10','campus-bw','42.4502416','-76.4853705']
]

printers_color = [

    ['aap-mil-1mfp/aap-mil-2mfp/aap-mil-3mfp/aap-mil-4mfp','Milstein Hall - Behind the elevators (2nd floor)','campus-bw, campus-color','42.451232','-76.4836401'],
    ['aap-nyc-1c','NYTech','campus-bw, campus-color','42.4439614','-76.5018807'],
    ['aap-nyc-1mfp','AAP NYC','campus-color','42.4509482','-76.48409099999999'],
    ['aap-rome-1c','Rome - Italy','campus-bw, campus-color','40.7433036','-73.87694379999999'],
    ['aap-sib-1c','Sibley Hall - 3rd Floor Lab (Barclay Jones],','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['aap-sib-3c','Sibley Hall - 2nd Floor Lab (ADMS])','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['aap-sib-3mfp/aap-sib-4c','Sibley Hall - 3rd Floor Balcony (inside dome)','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['aap-tjaden-1c','Tjaden Hall - Darkroom','campus-bw, campus-color','42.4509025','-76.4853131'],
    ['aep-netprint1','Clark Hall - Room 244','campus-bw, campus-color','42.4497606','-76.4812001'],
    ['africana-1st-floor','Africana first floor','campus-bw, campus-color','42.457403','-76.482239'],
    ['bin-color','Statler Hall 365 - by the lab monitor desk - closest to window','campus-bw, campus-color',42.4668288,-76.4851556],
    ['catherwood-library1','Catherwood Library','campus-bw, campus-color','42.4472562','-76.4811158'],
    ['catherwood-np4c','Catherwood Library - 236 Ives Hall - Reference Area','campus-bw, campus-color','42.4472562','-76.4811158'],
    ['cbs-olin-basement-2c','Olin Library','campus-bw, campus-color','42.447905','-76.484293'],
    ['cit-carp-2c','Carpenter Hall Computer Lab - Main Floor','campus-bw, campus-color','42.4856319','-76.4663403'],
    ['cit-mann220a-3c','Mann Library Computer Lab - Room 220A - Second Floor','campus-bw, campus-color','42.448766','-76.476312'],
    ['cit-ph318-3c','Phillips Hall Computer Lab - Room 318','campus-bw, campus-color','42.4445768','-76.4820529'],
    ['cit-rpcc-3c','Robert Purcell Community Center - RPCC - Computer Lab - Room 207','campus-bw, campus-color','42.4562967','-76.4783146'],
    ['cit-upson-3c','Upson Hall - Room 225','campus-bw, campus-color','42.4439852','-76.4828736'],
    ['cit-uris-4c','Uris Library - Tower Room Computer Lab - Downstairs from Entrance','campus-bw, campus-color','42.447905','-76.484293'],
    ['cit-weill-1c','B25 Weill Hall - 237 Tower Road','campus-bw, campus-color','42.4468068','-76.477214'],
    ['cit-wsh-3c','Willard Straight Hall - Computer Lab - Basement Level','campus-bw, campus-color','42.4465919','-76.4856765'],
    ['ciw1','District of Columbia - Cornell in Washington','campus-bw, campus-color','38.908422','-77.048536'],
    ['csmenglab','Gates Hall - Room G23','campus-bw, campus-color','42.4449769','-76.4810912'],
    ['fine-lib2c','Fine Arts Library - B56 Sibley Hall','campus-bw, campus-color','42.4512236','-76.4828622'],
    ['hollister2c','Hollister 202 CEE Undergrad Lounge','campus-bw, campus-color','42.444368','-76.48463919999999'],
    ['kroch-lib-2-mfp/kroch-lib-3-mfp','Kroch Library','campus-bw, campus-color','42.447774','-76.484160'],
    ['lacolor1','Kennedy Hall - Room 467','campus-bw, campus-color','42.4482603','-76.4793974'],
    ['law-mfp1','Law','campus-bw, campus-color','42.4438549','-76.48577239999997'],
    ['lincoln-2floor','lincoln-second floor','campus-bw, campus-color','42.4501817','-76.4833675'],
    ['mann-mfp1/mann-mfp2','Mann','campus-bw, campus-color','42.448766','-76.47631179999999'],
    ['mann4c','Mann Library - First Floor','campus-bw, campus-color','42.448766','-76.47631179999999'],
    ['mann5color','Mann Library - Basement B30 Area','campus-bw, campus-color','42.448766','-76.47631179999999'],
    ['math-lib3c','Mallott Hall - Math Library - Fourth Floor','campus-bw, campus-color','42.4482224','-76.4802083'],
    ['mpslab','Gates Hall - Room G23','campus-bw, campus-color','42.4449769','-76.4810912'],
    ['mth-color','Myron Taylor Hall 2nd Floor Computer Lab','campus-bw, campus-color','42.444460','-76.486113'],
    ['nytech-netprnt1','Roosevelt Island - Bloomberg Center Room 181','campus-color','40.76050310000001','-73.9509934'],
    ['nytech-netprnt2','NYTech - 111 8th Avenue','campus-color','42.4439614','-76.5018807'],
    ['olin-lib-4thfloor','Olin Library - Room 425 - Fourth Floor','campus-bw, campus-color','42.447905','-76.484293'],
    ['olin-lib-gradlounge','Olin Library Graduate Lounge','campus-bw, campus-color','42.447905','-76.484293'],
    ['olin-lib5c','Olin Library - behind the reference desk','campus-bw, campus-color','42.447905','-76.484293'],
    ['sage-301-color','Sage Hall Library - Room 302 - Third Floor Collaboration Space','campus-bw, campus-color','42.4458947','-76.4832581'],
    ['sage-lib1-color','Sage Hall - Library - First Floor','campus-bw, campus-color','42.4458918','-76.4833009'],
    ['sage-mfp1','Sage Johnson First Floor Room 101','campus-bw, campus-color','42.4458947','-76.4832581'],
    ['sage-mfp2/sage-mfp3','Sage','campus-bw, campus-color','42.4397199','-76.49146619999999'],
    ['scl-malott','Mallot','campus-bw, campus-color','42.4482224','-76.4802083'],
    ['sha-mslc-color','Nestle Library - west side of reference desk','campus-bw, campus-color','42.445541','-76.48215429999999'],
    ['sibley1-b56','Sibley','campus-bw, campus-color','42.4509802','-76.4840158'],
    ['sips-ps170-1c','Plant Science Building - Room 170','campus-bw, campus-color','42.4483258','-76.4770262'],
    ['uris-lib-mfp1','Uris Library Austen Room','campus-bw, campus-color','42.447905','-76.484293'],
    ['uris-lib2c','Uris Library - In Front of Circulation Desk','campus-bw, campus-color','42.447905','-76.484293'],
    ['vetlib5','Schurman Hall - S1201','campus-bw, campus-color','42.4480179','-76.4661765'],
    ['vetschool-library1','Vet School Library','campus-bw, campus-color','42.4474921','-76.4658424']

]

############################


def find_me(key):
    '''returns user's coordinates - still pretty imprecise!'''
    # API from https://ipstack.com/documentation
    send_url = 'http://api.ipstack.com/check?access_key='+key
    geo_req = requests.get(send_url)
    geo_json = json.loads(geo_req.text)
    latitude = geo_json['latitude']
    longitude = geo_json['longitude']
    return (latitude,longitude)

def gc_dist(lat_1,lon_1,lat_2,lon_2):
    '''find distance (in km) between any two great circle points'''
    # convert decimal degrees to radians 
    lat_1, lon_1, lat_2, lon_2 = map(radians, [lat_1, lon_1, lat_2, lon_2])
    # haversine formula 
    dlon = lon_2 - lon_1 
    dlat = lat_2 - lat_1
    a = sin(dlat/2)**2 + cos(lat_1) * cos(lat_2) * sin(dlon/2)**2
    c = 2 * asin(sqrt(a)) 
    km = 6367 * c
    #end of calculation
    #limit decimals
    return km

def min_dist(printers,me_pos):
    '''
    for every printer:
        1. finds printer location
        2. adds printer to list
        3. sorts printer and removes 
    returns list
    '''
    # fake distance for debugging - if code is successful, '' printer should not be printed
    dists = [('',10000000000000)]
    for printer in printers:
        lat = float(printer[3])
        lon = float(printer[4])
        newdist = gc_dist(me_pos[0],me_pos[1],lat,lon)
        if available(''): # argument should be printer[5]
            dists.append((printer[1],newdist))
        dists.sort(key=(lambda x: x[1]))
        if len(dists)>5:
            dists.pop()
    dists.sort(key=(lambda x: x[1]))
    return dists

def available(schedule):
    '''returns True if printer is available; currently inoperable. must add schedules to dataframe.'''
    return True

def print_answer(dists):
    '''Prints answer'''
    for i in range(len(dists)):
        print('Option '+str(i+1)+': go to printer \''+dists[i][0]+'\', which is '+str(dists[i][1])+' km away and probably open.\n')

def color(args):
    return not set(args).isdisjoint(['color','c'])

def bw(args):
    return not set(args).isdisjoint(['bw','black and white','black-and-white'])

if __name__ == '__main__':
    from sys import argv
    from sys import exit
    args = [i.lower() for i in argv]
    #print(argv)
    #print('length',len(argv))
    if any('auto' in x for x in args):
        key = '5458b0ab5799bb832c995cb32879cb85'
        if len(key) == 0:
            key = prompt('API key? (can get for free at https://ipstack.com/product) : ')
        pos = find_me(key)
    else:
        pos = [float(i) for i in input('Enter your coordinates (comma separation)\ntry https://www.gps-coordinates.net/ (control-click)\nor call module with argv "auto" for a very-inaccurate automatic gps calculation\n0 to cancel\nCoors: ').split(',')]
    if pos == [0]:
        exit()
    if len(args) > 1 and (bw(args) or color(args)):
        if bw(args):
            answer_bw = min_dist(printers_bw,pos)
            print_answer(answer_bw)
        elif color(args):
            answer_color = min_dist(printers_color,pos)
            print_answer(answer_color)            
    else:
        answer_bw = min_dist(printers_bw,pos)
        answer_color = min_dist(printers_color,pos)
        print('black-and-white printers:\n')
        print_answer(answer_bw)
        print('\n\ncolor printers:\n')
        print_answer(answer_color)
        

