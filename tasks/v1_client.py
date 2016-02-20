#!/usr/bin/env python 
# -*- coding: utf-8 -*-

from celery import Celery
  
results = []
celery = Celery()
celery.config_from_object('celeryconfig')



for x in range(1,5):
	results.append(celery.send_task("tasks.multiply",[2,2]))
