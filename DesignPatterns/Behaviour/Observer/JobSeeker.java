package Behaviour.Observer;
// Questo è il nostro concrete Observer
public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name){
        this.name = name;
    }

    public void onJobPosted(JobPost job){
        System.out.println("Hi " + name + "! New job posted: " + job.getTitle());
    }
}
