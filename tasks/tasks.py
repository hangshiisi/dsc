#from celery import Celery

#app = Celery('tasks', broker='amqp://guest@localhost//')

#@app.task
#def add(x, y):
#	    return x + y

from celery.task import task
 
@task
def multiply(x, y):
    multiplication = x * y
    return "The result is " + str(multiplication)



