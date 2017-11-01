class SJf
{
	static ArrayList<Process> processes=new ArrayList<Process>();
	public static void main(String[] args) 
	{
		int numofprocess=10;
		int meanBurstTime=10;
		int meanArrivalTime=10;

		for(int i=0;i<numofprocess;i++)
		{
			processes.add(new Process(meanArrivalTime, meanBurstTime));
		}

		//FIFO
		ArrayList<Process> q=new ArrayList<Process>();
		int tt=100, count=0;

		while(count<tt)
		{
			for(int i=0;i<numofprocess;i++)
			{
				if(processes.get(i).arrivalTime<=count)
				{
					q.add(processes.get(i));
				}
				// else break;
			}

			if(q.size()!=0)
			{
				q.get(0).waitTime=count-arrivalTime;
				q.get(0).turnAroundTime=q.get(0).burstTime+q.get(i).waitTime;
				count+=	q.get(0).burstTime;
			}
		}
	}
}