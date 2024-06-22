package ironhack.com.helloplantmanagment.contoller;

import ironhack.com.helloplantmanagment.model.Worker;
import ironhack.com.helloplantmanagment.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor


public class WorkerController {
    private final WorkerService workerService;

    @GetMapping
    public List<Worker> findAll() {
        return workerService.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Worker addWorker(@RequestBody @Valid Worker worker) {
        return workerService.addWorker(worker);
    }

    @PutMapping("/{workerId}")
    public Worker updateWorker(@PathVariable("workerId") Long workerId,
                               @RequestBody Worker worker) {
        return workerService.updateWorker(workerId, worker);
    }

    @DeleteMapping("/{workerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorker(@PathVariable("workerId") Long workerId) {
        workerService.deleteWorker(workerId);
    }
}







