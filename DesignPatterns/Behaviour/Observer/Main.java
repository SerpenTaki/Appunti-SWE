package Behaviour.Observer;

public class Main {
    public static void main(String[] args){
        //Create job seekers
        JobSeeker riccardoBaldin = new JobSeeker("Riccardo Baldin");
        JobSeeker johnDoe = new JobSeeker("John Doe");

        //Create employment agency and register job seekers
        EmploymentAgency agency = new EmploymentAgency();
        agency.attach(riccardoBaldin);
        agency.attach(johnDoe);

        //Post a new job and notify job seekers
        agency.addJob(new JobPost("Software Engineer"));

        agency.detach(riccardoBaldin);
        System.out.println("Riccardo Hired!");


        agency.addJob(new JobPost("Mcdonald Manager"));
    }
}
