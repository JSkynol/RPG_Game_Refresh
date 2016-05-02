package main.quest.interfaces;

public class Quests{
	public String questName;//(String name);
	public Quests questPrev ;//(Quests questprev);
	//public  void questCompletion;//(/* item pickup/talk to someone/update info */);
	public Quests questNext;// (Quests questnext);
	public String questDescription;// (String description);
	public boolean questTimed;
	public int questTimeRequired;
	public Quests(String name,Quests qprev, Quests qnext, String desc,boolean timed, int time){
		questName = name;
		questPrev = qprev;
		questNext = qnext;
		questDescription = desc;
		questTimed = timed;
		questTimeRequired = time;
	}
	public void setQuestName(String name){
		questName = name;
	}
	public void setQuestPrev(Quests prev){
		questPrev = prev;
	}
	public void setQuestNext(Quests next){
		questNext=next;
	}
	public void setDescription(String desc){
		questDescription = desc;
	}
	public void isTimedQuest(boolean timed){
		questTimed = timed;
	}
	public void setTimedQuest(int time){
		
		if(time == -1){
		questTimeRequired = time;
		questTimed = true;
	}}
}
