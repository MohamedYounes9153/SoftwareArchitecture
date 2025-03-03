package demo.service;

import demo.model.MessageQueue;
import demo.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueueService {

    @Autowired
    private QueueRepository queueRepository;

    public List<MessageQueue> findAllQueues() {
        return queueRepository.findAll();
    }

    public Optional<MessageQueue> findQueueById(long id) {
        return queueRepository.findById(id);
    }

    public MessageQueue saveQueue(MessageQueue queue) {
        return queueRepository.save(queue);
    }

    public void deleteQueue(long id) {
        queueRepository.deleteById(id);
    }

    public List<MessageQueue> findByPrefix(String prefix) {
        return queueRepository.findAll()
                .stream()
                .filter(q -> q.getName().startsWith(prefix))
                .collect(Collectors.toList());
    }
    
}
