/**
 * Created by madhu on 30/9/14.
 */

import org.apache.mesos.MesosSchedulerDriver
import org.apache.mesos.Protos.FrameworkInfo
import scala.concurrent.ExecutionContext.Implicits.global 
import scala.concurrent.Future
import scala.concurrent.duration._



/**
 * Client program which will launch shell commands on cluster
 * Read README.md for example invocation.
 */
object Main {

  def main(args: Array[String]) {

    val framework = FrameworkInfo.newBuilder.
    setName("MainShell").
    setUser("").
    setRole("*").
    setCheckpoint(false).
    setFailoverTimeout(0.0d).
    build()

    //create instance of schedule and connect to mesos
    val scheduler = new ScalaScheduler
    //submit shell commands
    scheduler.submitTasks(args:_*)
    
    for (a <- args) { 
        println("The command is " + a) 
    }

    val mesosURL = "10.10.10.2:5050"
    println("Hello world 1\n") 
    val driver = new MesosSchedulerDriver(scheduler,framework,mesosURL)
    //run the driver
    Future { driver.run() } 

    println("XXXXX Hello world 2\n") 
    val NEWLINE = '\n'.toInt 
    while (System.in.read != NEWLINE) { 
        Thread.sleep(1000)
    } 

    driver.stop()  
    sys.exit(0)




  }


}

