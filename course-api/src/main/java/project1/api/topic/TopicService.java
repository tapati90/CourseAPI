package project1.api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics= new ArrayList<>(Arrays.asList(
			new Topic("1001","JavaPlus","Training"),
			new Topic("1002","Teradata","Infosys"),
			new Topic("1003","java","Tcss")
			));

    public List<Topic> getAllTopics()
    {
    	return topics;
    }
    
    public Topic getTopic(String id)
    {
    	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	/*public void updateTopic(Topic topic, String id) {
		topics.forEach(topicEach ->
		{
			if(topicEach.getId().equals(id))
				topics.set(topics.indexOf(topicEach),topic);
		});
	}*/
	
	public void updateTopic(Topic topic, String id) {
	for(int i=0 ;i<topics.size();i++)
	{
		Topic topicNew = topics.get(i);
		if(topicNew.getId().equals(id))
		{
			topics.set(i, topic);
			return;
		}
	}
	
}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}

