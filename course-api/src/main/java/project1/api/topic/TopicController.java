package project1.api.topic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;


	@RequestMapping("/getAllTopics")
	public String getAllTheTopics()
	{
		return "Default return all the topics";
	}
	
	//View all the topics
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	//View the topic based on Id
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	//Add new topic
	@RequestMapping(method=RequestMethod.POST , value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	
	//Update new topic
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		topicService.updateTopic(topic,id);
	}
	
	//Delete topic based on Id
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		 topicService.deleteTopic(id);
	}
	
}
