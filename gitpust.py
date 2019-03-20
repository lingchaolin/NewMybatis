# -*- coding: utf-8 -*- 

import os
import time

os.system('git add .')
now = time.strftime('%Y-%m-%d_%H:%M:%S',time.localtime(time.time()))
os.system('git pull origin')
os.system('git commit -m '+str(now))
os.system('git push origin master')
