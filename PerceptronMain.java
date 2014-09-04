import java.util.*;


 
class Dataset
{
    final int q=5;
	int x,y,out;
	Dataset(int a,int b,int c)
	{
		x = a;
		y = b;
		out = c;
	}
}

class Perceptron
{
	private double w1,w2,net;
	static final double alpha = 0.7;
	static final int q = 5;
	Random r = new Random();
	Perceptron()
	{
		w1 = r.nextInt(10);
		w2 = r.nextInt(10);
		net = 0.0;
		System.out.println("INITIAL WEIGHTS BEFORE TRAINING: "+w1+"  "+w2);
	} 
	public void train(ArrayList<Dataset> d)
	{
		for(Dataset i:d)
		{   int a = test(i.x,i.y);
			w1 = w1 + alpha*(i.out-a)*i.x;
			w2 = w2 + alpha*i.y*(i.out-a);	
			System.out.println("WEIGHTS IN TRAINING: "+w1+"  "+w2);	
		}
		
		System.out.println("FINAL WEIGHTS AFTER TRAINING: "+w1+"  "+w2);
	}
	
	public int test(int a, int b)
	{
		net = w1*a + w2*b;
		return binarystep(net);
	}
	public int binarystep(double n)
	{
	
		
		if (n>=q)
			return 1;
			else return 0;
	}
}

class PerceptronMain
{
	
	public static void main(String args[])
	{
		int x,y,output,n;
		ArrayList<Dataset> a = new ArrayList<Dataset>();
		Scanner sc = new Scanner(System.in);
		
		
		
		a.add(new Dataset(1,1,1));
		a.add(new Dataset(0,0,0));
		a.add(new Dataset(0,1,0));
		a.add(new Dataset(1,0,0));
		
		Perceptron h = new Perceptron();
		h.train(a);
		
		System.out.println("Enter x:");
		x=sc.nextInt();
		System.out.println("Enter y:");
		y=sc.nextInt();
		
		System.out.println("OUTPUT:"+h.test(x,y));
		
	}
}
