package ironhack.com.helloplantmanagment.service;

import ironhack.com.helloplantmanagment.Repository.WorkerRepository;
import ironhack.com.helloplantmanagment.model.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //
@Slf4j


public class WorkerService {
    private final WorkerRepository workerRepository;

    //view all workers
    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    //add a single worker
    public Worker addWorker(Worker worker){
        log.info("Adding new worker{}", worker);
        return workerRepository.save(worker);
    }

    //delete worker by ID
    public void deleteWorker(Long workerId){
        log.info("Removing worker with id {}", workerId);

        workerRepository.deleteById(workerId);
    }

    //update worker
    public Worker updateWorker(Long workerId, Worker worker){
        log.info("Updating worker with id{}",  workerId);
        var workerToUpdate = workerRepository.findById(workerId).orElseThrow();
        workerToUpdate.setName(worker.getName());
        workerToUpdate.setAddress(worker.getAddress());
        return workerRepository.save(workerToUpdate);


//        log.info("Updating worker's address to {}", address);
//        log.info("Updating worker's name and address to {}", name, address);


    }

}
