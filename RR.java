class RR
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

		Collections.sort(processes, SORT_BY_ARRIVALTIME);

		while(count<tt)
		{
			for(int i=0;i<numofprocess;i++)
			{
				if(processes.get(i).arrivalTime<=count)
				{
					q.add(processes.get(i));
				}
				else break;
			}

			for (int i = 0 ; i < q.size(); i++)
			{
				if (q.get(i).remBurstTime > 0)
				{
					if (q.get(i).remBurstTime > quantum)
					{
						count += quantum;
						q.get(i).remBurstTime -= quantum;
					}
					else
					{
						count+ =  q.get(i).remBurstTime;
						q.get(i).waitTime = count - q.get(i).burstTime;
						q.get(i).turnAroundTime=q.get(i).burstTime+q.get(i).waitTime;
						q.remove(i);
					}
				}
			}
		}
	}
}