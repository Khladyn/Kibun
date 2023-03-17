import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Option3 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(0) never", "(1) almost never", "(2) sometimes", "(3) fairly often", "(4) very often"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String total = "";
	private String a = "";

	public Option3() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Perceived Stress Scale (PSS)");
		
		this.setInstructions("\nPlease read each statement and choose the option that best describes the amount of time "
				+ "you felt that way over the past four weeks. There are no right or wrong answers. Do not spend too much time "
				+ "on any statement.");
		
		this.setEBackground("\nThe Perceived Stress Scale is a 10-item questionnaire that measures the degree to which situations "
				+ "in one’s life are appraised as stressful. Items were designed to assess how unpredictable, uncontrollable, and "
				+ "overloaded respondents find their lives to be. It also includes a number of direct queries about current levels of "
				+ "experienced stress.");
		
		questions.add("index zero");
		
		questions.add("In the last month, how often have you been upset because of something that happened unexpectedly?");
		
		questions.add("In the last month, how often have you felt that you were unable to control the important things in your life?");
		
		questions.add("In the last month, how often have you felt nervous and “stressed”?");
		
		questions.add("In the last month, how often have you felt confident about your ability to handle your personal problems?");
		
		questions.add("In the last month, how often have you felt that things were going your way?");
		
		questions.add("In the last month, how often have you found that you could not cope with all the things that you had to do?");
		
		questions.add("In the last month, how often have you been able to control irritations in your life?");
		
		questions.add("In the last month, how often have you felt that you were on top of things?");
		
		questions.add("In the last month, how often have you been angered because of things that were outside of your control?");
		
		questions.add("In the last month, how often have you felt difficulties were piling up so high that you could not overcome them?");
		
		this.setQuestions(questions);
		
		this.setLikert(likert);		
		
	}
	
	@Override
	public void next1() {
		brp8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp8.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				
				if(jbg.getSelection() == null) {
					brp8.setEnabled(false);
					new JOptionPane();
					JOptionPane.showMessageDialog(jlp2, "Please choose an answer");
					
				} else {
					resu[i] = jbg.getSelection().getActionCommand();
			
					brp8.setEnabled(true);
					i++;
					num.setText(i.toString());
					bg5.setText(questions.get(i));
					jt4.setEnabled(true);
				}
				
				if (i == questions.size() - 1) {
					brp8.setVisible(false);
					brp11.setVisible(true);
				}
				jbg.clearSelection();
			}
			
		});
	}
	
	public void finish1() {
		brp11.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				
				if(jbg.getSelection() == null) {
					brp11.setEnabled(false);
					new JOptionPane();
					JOptionPane.showMessageDialog(jlp2, "Please choose an answer");
					
				} else {
					resu[i] = jbg.getSelection().getActionCommand();
					try {
						formula();
						setScore(score);
						setExplanation(explanation);
					} catch (IOException e) {
						e.printStackTrace();
					}
					brp11.setEnabled(true);
					jlp2.setVisible(false);
					jlp3.setVisible(true);
					i = 1;
					num.setText(i.toString());
					bg5.setText(questions.get(i));
				}
			}
		});	

	}
	
	@Override
	public void formula() throws IOException {
		
		Integer tally = 0;
		
		for (int i = 0; i < resu.length; i++)
		{
			if (i == 4 || i == 5 || i == 7 || i == 8)
			{
				if (resu[i] == likert[0])
				{
					tally+=4;
				}
				if (resu[i] == likert[1])
				{
					tally+=3;
				}
				if (resu[i] == likert[2])
				{
					tally+=2;
				}
				if (resu[i] == likert[3])
				{
					tally+=1;
				}
				if (resu[i] == likert[4])
				{
					tally+=0;
				}
				
			} else {
			
				if (resu[i] == likert[0])
				{
					tally+=0;
				}
				if (resu[i] == likert[1])
				{
					tally+=1;
				}
				if (resu[i] == likert[2])
				{
					tally+=2;
				}
				if (resu[i] == likert[3])
				{
					tally+=3;
				}
				if (resu[i] == likert[4])
				{
					tally+=4;
				}
			}
			
			total = tally.toString();
		}
		
		if (tally >= 0 && tally <= 13)
		{
			score = "Low stress";
			a = "This does not mean you won’t feel the effects of stress, but beginning stress-management techniques now will go a long way to improving your sense of well-being.";
		}
		if (tally >= 14 && tally <= 26)
		{
			score = "Moderate stress";
			a = "Taking steps to manage stress now will help to prevent serious physical, psychological, and emotional problems.";
		}
		if (tally >= 27 && tally <= 40)
		{
			score = "High perceived stress";
			a = "Chronic stress disrupts nearly every system in your body. It can suppress your immune system, upset your digestive and reproductive systems, increase the risk of heart attack and stroke, and speed up the aging process.";
		}
		
		explanation = "Score: " + tally + "\n" + a;
				
	}

	@Override
	public void printr() {
		tkp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				String path = System.getProperty("user.home") + File.separator + "PSS_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "PSS_results_" + i.toString() + ".txt";
							results = new File(path);
							i++;
					};
						br = new BufferedWriter(new FileWriter(results, true));
						br.write("NAME: " + getUName());
						br.newLine();
						br.write("AGE: " + getAge());
						br.newLine();
						br.write("GENDER: " + getGender());
						br.newLine();
						br.write("DATE: " + getUDate());
						br.newLine();
						br.write("TEST: " + getExamname());
						br.newLine();
						br.newLine();
						
						for(int j = 1; j < questions.size(); j++) {
							br.write("[" + j + "] " + questions.get(j));
							br.newLine();
							br.write(resu[j]);
							br.newLine();
							br.newLine();
						}
						
						br.write("SCORE: " + total);
						br.newLine();
						br.newLine();
						br.write(score);
						br.newLine();
						br.write(a);
						br.newLine();
						br.newLine();
						br.write("NOTE: Scores for items 4, 5, 7, and 8 are reversed.");
						br.newLine();
						
						br.flush();
						br.close();
						
					JOptionPane.showMessageDialog(getContentPane(), "File is successfully downloaded. (" + i.toString() + ")");
					
				} catch (IOException e) {
					e.printStackTrace();
				}				
		    }

		});		
	}
	
	
}
