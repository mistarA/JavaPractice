package testExamples

import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.TimeUnit
import javax.print.attribute.standard.JobName

class Job constructor(val jobName: String, val jobPriority: JobPriority) : Runnable {

    override fun run() {
        System.out.println("Job:" + jobName +
                " Priority:" + jobPriority)
        Thread.sleep(1000); // to simulate actual execution time
        println(Thread.currentThread())
    }
}

enum class JobPriority {

    //Whichever comes first will get high priority
    HIGH,
    MEDIUM, LOW
}

class PriorityJobScheduler(poolSize: Int, queueSize: Int) {

    var priorityJobPoolExecutor: ExecutorService
    var priorityJobScheduler = Executors.newSingleThreadExecutor()
    var priorityJobQueue: PriorityBlockingQueue<Job>

    init {
        priorityJobQueue = PriorityBlockingQueue(queueSize, Comparator.comparing(Job::jobPriority))
        priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize)
        priorityJobScheduler.execute({

            //while(true) is important so that jobs in queue keep getting executed, once they get inserted into the queue
            while (true) {
                try {
                    priorityJobPoolExecutor.execute(priorityJobQueue.take())
                } catch (exception: InterruptedException) {
                    break;
                }
            }
        })
    }

    fun scheduleJob(job: Job) {
        priorityJobQueue.add(job)
    }

    fun shutdown() {
        priorityJobPoolExecutor.awaitTermination(3000, TimeUnit.SECONDS)
    }
}

fun main(args: Array<String>) {
    val job1 = Job("Job1", JobPriority.LOW)
    val job2 = Job("Job2", JobPriority.MEDIUM)
    val job3 = Job("Job3", JobPriority.HIGH)
    val job4 = Job("Job4", JobPriority.MEDIUM)
    val job5 = Job("Job5", JobPriority.LOW)
    val job6 = Job("Job6", JobPriority.HIGH)

    val priorityJobScheduler = PriorityJobScheduler(2, 6)
    priorityJobScheduler.scheduleJob(job1)
    priorityJobScheduler.scheduleJob(job2)
    priorityJobScheduler.scheduleJob(job3)
    priorityJobScheduler.scheduleJob(job4)
    priorityJobScheduler.scheduleJob(job5)
    priorityJobScheduler.scheduleJob(job6)

    priorityJobScheduler.shutdown()
}