class Process
{
	int arrivalTime;
	int waitTime;
	int burstTime;
	int turnAroundTime;
	int remBurstTime;

	public Process(int meanBurstTime, int meanArrivalTime)
	{
		burstTime=getPoisson(10.0);
		arrivalTime=getExponential(10.0);
		remBurstTime=burstTime;
	}

	public static int getPoisson(double lambda) 
	{
		double L = Math.exp(-lambda);
		double p = 1.0;
		int k = 0;

		do
		{
			k++;
			p *= Math.random();
		} while (p > L);

		return k - 1;
	}

	public static double getExponential(double lambda)
	{
		return  Math.log(1-rand.nextDouble())/(-lambda);
	}
}