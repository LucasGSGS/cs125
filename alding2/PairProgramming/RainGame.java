//UIUC CS125 FALL 2013 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2013-10-01T11:20:25-0500.635270305
/**
 * @author panthap2,alding2
 */
 import java.util.Scanner;

public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
		int count=0;
		int x=100, y=0, dx=0, dy=0, score = 0;
		int z=100;
		int w=100;
		int dw=5;
		int dz=5;
		String text = "";
		long startTime =System.currentTimeMillis();
		long elapsed=0;
		int r=200;
		int g=300;
		int b=200;
		
		int level=1; 
		Scanner keyboard= new Scanner(System.in);
		while (true)
		{
		System.out.println("Enter a starting level between 1 and 5");
		
		level=keyboard.nextInt();
		if (level>=1 && level<=5)
			break;
		
		}
		
		
		Zen.setFont("Helvetica-64");
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				if (x<400)
				x +=50;
				else
					x=100;
				y = Zen.getZenHeight() / 2;
				
				dx = 0;
				dy = level*2;
				text = "" + (int) (Math.random() * 999);
				elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				
				//score += 3000 / elapsed;
			}
			r=(int)(Math.random()*300);
			g=(int)(Math.random()*300);
			b=(int)(Math.random()*300);
			Zen.setColor(r, g, b);
			
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(0, 255, 0);
			Zen.drawText("Level: "+ level,10,50);
			Zen.drawText("Score: " + score,10,100);
			Zen.setColor(100, 20, 200);
			Zen.drawText(text, x, y);
			Zen.setColor(200, 80, 10);
			Zen.drawText("CAT", 350, w);
			Zen.drawText("DOG", z, 300);
			
			Zen.drawText("NUMBERS", z+100, 400);
			Zen.drawText("LETTERS", 400, w+100);
			Zen.drawText("APPLE", 100, w+40);
			Zen.drawText("CRAZY", 50, w-35);
			Zen.drawText("PEAR", z+50, w);
			Zen.drawText("JAVA", z+300, w);
			Zen.drawText("WRONG", z-250, w);
			
		
			
			//Zen.drawText("Time: " + elapsed,10,150);
			Zen.flipBuffer();

			//Zen.sleep(DELAY);
			
			
			x += dx;
			y += dy;
			z+=dz;
			w+=dw;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				//if (text.length()>0){
				if(text.length()>0 &&c == text.charAt(0)) {
					text = text.substring(1,text.length()); // all except first character
					score+=100;
					count++;
					
				}
				
				if (text.length()>0 && c!=text.charAt(0))
				score-=100;
			
				
				
				
				//}
				
			}
			
			
			if (count>=10) {
				level++;
				count=0;						
			}
			if (w==Zen.getZenHeight())
				w=200;
			if (z==Zen.getZenWidth())
				z=100;
			if (y==Zen.getZenHeight())
				y=Zen.getZenHeight() / 2;
			
			
			
			Zen.sleep(90);// sleep for 90 milliseconds

		}
	}


}
