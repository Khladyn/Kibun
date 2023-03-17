import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class KibunTest extends JFrame implements Runnable {
	
	public void run() {
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KibunTest frame = new KibunTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */

//DEFAULT_VALUES
	public static int opt = 0;
	public static Integer i = 1;
	
	public static String name = "";
	public static String date = "";
	public static String age = "";
	public static String gender = "";
	
	private String examname = "Exam Name";
	private String instructions = "Here reads the instructions";
	private String background = "Here is some background of the exam";
	private static String disclaimer = "The psychological tests provided in this application "
			+ "are intended for educational purposes only and should not be considered as a "
			+ "substitute for a mental health evaluation by a licensed professional.";
	
	private ArrayList<String> questions = new ArrayList<String>();
	private String[] likert = new String[] {"1", "2", "3", "4", "5"};
	private String score = "Here is the result";
	private String explanation = "Here are some explanation";
	private String[] resu = new String[30];	
	
	public static JTextField num;
	private JPanel contentPane;

//GUI_COMPONENTS
	JLayeredPane jlp = new JLayeredPane();
	JLayeredPane jlp2 = new JLayeredPane();
	JLayeredPane jlp3 = new JLayeredPane();

	JTextField OpName;
	JTextArea bg;
	JTextArea bg2;
	JTextArea bg3;
	JTextField oph;
	JTextArea bg4;
	JTextField oph2;
	JTextPane bg5;
	
//LAYER_1
	JPanel shp = new JPanel();
	File br1 = new File("header.png");
	JPanel brp1 = getHLine(br1);
	File br4 = new File("logout.png");
	JPanel brp4 = getLogB(br4);
	JTextField bgl = getBg("BACKGROUND");
	JTextField bgl2 = getBg("DISCLAIMER");
	JTextField jt2 = uBack("< back");
	
//LAYER_1.2
	JTextField bgl3 = getBg("INSTRUCTIONS");
	JTextField jt3 = uBack("< back");
	File br7 = new File("beginb.png");
	JPanel brp7 = getBegB(br7);
	File br6 = new File("proc.png");
	JPanel brp6 = getProc(br6);
	
//LAYER_2	
	JTextField bgl4 = getBg("INSTRUCTIONS");
	File br9 = new File("circ.png");
	JPanel brp9 = getNum(br9);
	File br8 = new File("next.png");
	JPanel brp8 = getNext(br8);
	File br11 = new File("fin.png");
	JPanel brp11 = getFin(br11);
	JTextField jt4 = uBack("< back");
	
//LAYER_3
	JTextField res = getOpName("results");
	File tk = new File("pri.png");
	JPanel tkp = getTake(tk);
	File tk1 = new File("take1.png");
	JPanel tkp1 = getTake(tk1);
	File tk2 = new File("take2.png");
	JPanel tkp2 = getTake(tk2);
	File tk3 = new File("take3.png");
	JPanel tkp3 = getTake(tk3);
	
	JTextField res2;
	JTextPane res3;
	
	ButtonGroup jbg = new ButtonGroup();

//BORDERS
	Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);
	Border sbord = BorderFactory.createEmptyBorder(5,5,5,5);
	Border vbord = BorderFactory.createEmptyBorder(5,0,5,5);
	Border wbord = BorderFactory.createEmptyBorder(20,20,20,20);
	Border hbord = BorderFactory.createLineBorder(new Color(255,255,240,255), 3);
	
	public KibunTest() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 800, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255,255,240,255));
		setContentPane(contentPane);	
		
		OpName = getOpName(examname);
		bg = getIntro(background);
		bg2 = getIntro(disclaimer);
		bg3 = getIntro(instructions);
		oph = getOpName(examname);
		bg4 = getIntro(instructions);
		oph2 = getOpName(examname);
		res2 = getRes(score);
		res3 = getExp(explanation);
		
		questions.add("sample question 0");
		questions.add("sample question 1");
		questions.add("sample question 2");
		questions.add("sample question 3");
		questions.add("sample question 4");
		questions.add("sample question 5");
		
		jlp.setBackground(new Color(255,255,240,255));
		jlp.setSize(800, 450);
		jlp.setLayout(null);
		jlp.setLocation(0, 0);
		jlp.setOpaque(true);
		jlp.setVisible(true);
		
		jlp2.setBackground(new Color(255,255,240,255));
		jlp2.setSize(800, 450);
		jlp2.setLayout(null);
		jlp2.setLocation(0, 0);
		jlp2.setOpaque(true);
		jlp2.setVisible(false);
		
		jlp3.setBackground(new Color(255,255,240,255));
		jlp3.setSize(800, 450);
		jlp3.setLayout(null);
		jlp3.setLocation(0, 0);
		jlp3.setOpaque(true);
		jlp3.setVisible(false);

//LAYER_1		
		bg5 = getSheet();
		bg5.setLocation(0,40);
		jlp2.add(bg5, 1);
		
		shp.setSize(600, 175);
		shp.setLocation(100, 135);
		shp.setOpaque(true);
		shp.setBackground(new Color(198,217,191,255));
		shp.setLayout(null);
		shp.add(bg5);
		jlp2.add(shp,3);
			
		OpName.setLocation(175, 90);
		jlp.add(OpName, 0);

		brp1.setLocation(0,-15);
		brp1.setVisible(true);
		jlp.add(brp1, 1);
		
		brp4.setLocation(725,15);
		brp4.setVisible(true);
		jlp.add(brp4, 0);
		
			logOut();
		
		bgl.setLocation(100, 135);
		jlp.add(bgl, 0);
		
		bg.setLocation(100, 140);
		jlp.add(bg, 0);
		
		bgl2.setForeground(new Color(17,75,95,255));
		bgl2.setLocation(100,245);
		jlp.add(bgl2, 0);
		
		bg2.setForeground(new Color(17,75,95,255));
		bg2.setLocation(100, 250);
		jlp.add(bg2, 0);
		
		jt2.setLocation(100, 345);
		jlp.add(jt2, 0);
		
			getBack1();

		bgl3.setLocation(100,180);
		jlp.add(bgl3, 0);
		bgl3.setVisible(false);
		
		bg3.setLocation(100, 185);
		jlp.add(bg3, 0);
		bg3.setVisible(false);

		jt3.setLocation(100, 345);
		jlp.add(jt3, 0);
		jt3.setVisible(false);
		
			getBack2();

		brp7.setLocation(355, 345);
		brp7.setVisible(false);
		jlp.add(brp7, 0);
		
			begin1();
	
		brp6.setLocation(320, 345);
		jlp.add(brp6, 0);
	
//LAYER_2
		oph.setSize(800, 40);
		oph.setLocation(0, 0);
		jlp2.add(oph, 0);
		
		bgl4.setLocation(30, 50);
		jlp2.add(bgl4, 0);
		
		bg4.setSize(740, 100);
		bg4.setLocation(30, 55);
		jlp2.add(bg4, 0);
		
		brp9.setLocation(375, 115);
		brp9.setVisible(true);
		jlp2.add(brp9, 0);
		
			setLikert(likert);
		
		num = getInd();
		num.setText(i.toString());
		num.setLocation(382,129);
		jlp2.add(num, 0);
					
		brp8.setLocation(363, 345);
		brp8.setVisible(true);
		jlp2.add(brp8, 0);
		
		brp11.setLocation(360, 345);
		brp11.setVisible(false);
		jlp2.add(brp11, 0);
		
			next1();
			finish1();

		jt4.setLocation(100, 345);
		jlp2.add(jt4, 0);
		jt4.setVisible(true);	
		
			getBack3();
		
//LAYER_3
		oph2.setSize(800, 40);
		oph2.setLocation(0, 0);
		jlp3.add(oph2, 0);
		
		res.setFont(new Font("Metropolis Black", Font.PLAIN, 18));
		res.setSize(100, 30);
		res.setLocation(350, 60);
		jlp3.add(res, 0);
	
		tkp.setLocation(420, 300);
		tkp.setVisible(true);
		jlp3.add(tkp, 0);
		
			printr();
		
		tkp1.setLocation(210, 300);
		tkp1.setVisible(true);
		jlp3.add(tkp1, 0);
		
			retake();
		
		tkp2.setLocation(210, 345);
		tkp2.setVisible(true);
		jlp3.add(tkp2, 0);
		
			takeA();
		
		tkp3.setLocation(420, 345);
		tkp3.setVisible(true);
		jlp3.add(tkp3, 0);
		
			exitSA();
		
		res2.setLocation(100, 110);
		jlp3.add(res2, 0);
		
		res3.setLocation(125, 150);
		jlp3.add(res3, 0);
		res3.setVisible(true);
		
//METHODS
		
		contentPane.add(jlp);
		contentPane.add(jlp2);
		contentPane.add(jlp3);
	}
	
	
//ELEMENTS	
	public JTextPane getExp(String s)
	{
		JTextPane jt = new JTextPane();
		jt.setText(s);
		jt.setOpaque(true);
		jt.setFont(new Font("Metropolis Medium", Font.PLAIN, 16));
		jt.setForeground(new Color(255,255,240,255));
		jt.setBackground(new Color(17,75,95,255));
		jt.setBorder(wbord);
		jt.setSize(550, 125);
		jt.setEditable(false);
		
		StyledDocument sd = jt.getStyledDocument();
		SimpleAttributeSet st = new SimpleAttributeSet();
		StyleConstants.setAlignment(st, StyleConstants.ALIGN_CENTER);
		sd.setParagraphAttributes(0, sd.getLength(), st, false);
		
		return jt;
	}

	public JTextField getRes(String s) throws IOException
	{
		JTextField jt = new JTextField();
		jt.setText(s);
		jt.setHorizontalAlignment(SwingConstants.CENTER);
		jt.setBorder(nobord);
		jt.setFont(new Font("Metropolis Black", Font.PLAIN, 28));
		jt.setForeground(new Color(17,75,95,255));
		jt.setOpaque(false);
		jt.setSize(600, 30);
		jt.setEditable(false);
		
		return jt;
	}
	
	public JPanel getTake(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(170, 35, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(170,35);
		durp.setOpaque(false);
		
		return durp;
	} 
	
	public JTextField getInd() throws IOException
	{
		JTextField jt = new JTextField();
		jt.setHorizontalAlignment(SwingConstants.CENTER);
		jt.setFont(new Font("Metropolis Black", Font.PLAIN, 18));
		jt.setForeground(new Color(255,255,240,255));
		jt.setOpaque(false);
		jt.setSize(30, 20);
		jt.setBorder(nobord);
		jt.setEditable(false);
		
		return jt;
	}
	
	public JToggleButton getBut(String s)
	{
		Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);

		JToggleButton jb = new JToggleButton();
		jb.setText(s);
		jb.setHorizontalAlignment(SwingConstants.CENTER);
		jb.setFont(new Font("Metropolis Medium", Font.PLAIN, 14));
		jb.setBackground(new Color(27,147,111,255));
		jb.setForeground(new Color(255,255,240,255));
		jb.setFocusPainted(false);
		jb.setBorder(nobord);
		jb.setSize(120, 40);
		
		return jb;
	}
	
	public JTextPane getSheet()
	{
		JTextPane jt = new JTextPane();
		jt.setOpaque(false);
		jt.setLayout(null);
		jt.setFont(new Font("Metropolis Black", Font.PLAIN, 18));
		jt.setForeground(new Color(17,75,95,255));
		jt.setBackground(new Color(198,217,191,255));
		jt.setBorder(wbord);
		jt.setSize(600, 100);
		jt.setEditable(false);
		
		StyledDocument sd = jt.getStyledDocument();
		SimpleAttributeSet st = new SimpleAttributeSet();
		StyleConstants.setAlignment(st, StyleConstants.ALIGN_CENTER);
		sd.setParagraphAttributes(0, sd.getLength(), st, false);

		return jt;
	}
	
	public JPanel getNum(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(43, 45, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(43, 45);
		durp.setOpaque(false);
		
		return durp;	
	}
	
	public JPanel getFin(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(80, 35, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(80, 35);
		durp.setOpaque(false);
		
		return durp;
	} 
	
	public JPanel getNext(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(75, 35, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(75, 35);
		durp.setOpaque(false);
		
		return durp;
	} 
	
	public JPanel getBegB(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(90, 35, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(90, 35);
		durp.setOpaque(false);
		
		return durp;	
	} 
	
	public JPanel getProc(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(160, 35, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(160,35);
		durp.setOpaque(false);
		
		return durp;
	} 
	
	public JTextField uBack(String s) throws IOException
	{
		JTextField jt = new JTextField();
		jt.setText(s);
		jt.setHorizontalAlignment(SwingConstants.LEFT);
		jt.setFont(new Font("Metropolis Black", Font.PLAIN, 14));
		jt.setForeground(new Color(26,148,111,255));
		jt.setOpaque(false);
		jt.setBorder(sbord);
		jt.setSize(100, 30);
		jt.setLocation(250, 220);
		jt.setCaretColor(getForeground());
		jt.setEditable(false);
		
		return jt;
	}
	
	public JTextArea getIntro(String s)
	{
		JTextArea jt = new JTextArea();
		jt.append("\n" + s);
		jt.setLineWrap(true);
		jt.setWrapStyleWord(true);
		jt.setOpaque(false);
		jt.setFont(new Font("Metropolis Medium", Font.PLAIN, 14));
		jt.setForeground(new Color(27,147,111,255));
		jt.setBorder(vbord);
		jt.setSize(625, 100);
		jt.setEditable(false);
		
		return jt;
	}
	
	public JTextField getBg(String s) throws IOException
	{
		JTextField jt = new JTextField();
		jt.setText(s);
		jt.setHorizontalAlignment(SwingConstants.LEFT);
		jt.setFont(new Font("Metropolis Black", Font.PLAIN, 14));
		jt.setForeground(new Color(26,148,111,255));
		jt.setOpaque(false);
		jt.setBorder(sbord);
		jt.setSize(150, 30);
		jt.setLocation(250, 220);
		jt.setCaretColor(getForeground());
		jt.setEditable(false);
		
		return jt;
	}
	
	public JTextField getOpName(String s)
	{
		Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);

		JTextField jt = new JTextField();
		jt.setText(s);
		jt.setHorizontalAlignment(SwingConstants.CENTER);
		jt.setFont(new Font("Metropolis Medium", Font.PLAIN, 18));
		jt.setBackground(new Color(27,147,111,255));
		jt.setForeground(new Color(255,255,240,255));
		jt.setBorder(nobord);
		jt.setSize(450, 30);
		jt.setEditable(false);
		
		return jt;
	}

	public JPanel getHLine(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(800, 100, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(800, 100);
		durp.setOpaque(false);
		
		return durp;	
	}
	
	public JPanel getLogB(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(35, 30);
		durp.setOpaque(false);
		
		return durp;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
		OpName.setText(examname);
		oph.setText(examname);
		oph2.setText(examname);
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
		bg3.setText(instructions);
		bg4.setText(instructions);
	}

	public String getEBackground() {
		return background;
	}

	public void setEBackground(String background) {
		this.background = background;
		bg.setText(background);		
	}

	public static String getDisclaimer() {
		return disclaimer;
	}

	public static void setDisclaimer(String disclaimer) {
		KibunTest.disclaimer = disclaimer;
	}

	public ArrayList<String> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<String> questions) {
		this.questions.clear();
		this.questions.addAll(questions);		
	}

	public String[] getLikert() {
		return likert;
	}

	public void setLikert(String[] likert) {
		this.likert = likert;

		int ix = 100;
		int y = 285;
						
		for (Integer i = 0; i < likert.length; i++) {
			JToggleButton j = getBut(likert[i]);
							
			j.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					j.setCursor(new Cursor(Cursor.HAND_CURSOR));
					j.setBackground(new Color(255,255,240,255));
					j.setForeground(new Color(27,147,111,255));
				}
								
				public void mouseExited(MouseEvent me) {
					j.setForeground(new Color(255,255,240,255));
					j.setBackground(new Color(27,147,111,255));
				}
			});
							
			jbg.add(j);
			j.setActionCommand(likert[i]);
			j.setLocation(ix, y);

			jlp2.add(j, 0);
					
			ix+=120;
		}
}

	public String getScore() {
		return score;
	}

	public void setScore(String score) throws IOException {
		this.score = score;		
		res2.setText(score);
	}

	public String getExplanation() {
		
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
		res3.setText(explanation);
	}

	public String[] getResu() {	

		return resu;
	}	

	public void setResu(String[] resu) {
		
		this.resu = resu;
	}

	
	public void logOut() {
		brp4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
			KibunSAmain km;
			
				try {
					km = new KibunSAmain();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			        dispose();
			}
		});
	}
	
	public void getBack1() {
		jt2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				jt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				dispose();
			}
			
		});
	}
	
	public void getBack2() {
		jt3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				jt3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				brp6.setVisible(true);
				brp7.setVisible(false);
				jt3.setVisible(false);
				bgl3.setVisible(false);
				bg3.setVisible(false);
				jt2.setVisible(true);
				bg2.setVisible(true);
				bgl2.setVisible(true);
				bg.setVisible(true);
				bgl.setVisible(true);
			}
			
		});
	}
	
	public void getBack3() {
		jt4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				jt4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				
				if(i == 1) {
					jlp2.setVisible(false);
					jlp.setVisible(true);
					bgl3.setVisible(true);
					jt3.setVisible(true);
					brp7.setVisible(true);
					
				} else {
					i--;
					brp8.setVisible(true);
					brp11.setVisible(false);
					num.setText(i.toString());
					bg5.setText(questions.get(i));
					jbg.clearSelection();
				}
			}
		});	
	}
	
	public void begin1() {
		brp7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp7.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				jlp.setVisible(false);
				jlp2.setVisible(true);
				bg5.setText(questions.get(i));
			}
			
		});	
		
		brp6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp6.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				brp6.setVisible(false);
				brp7.setVisible(true);
				jt3.setVisible(true);
				bgl3.setVisible(true);
				bg3.setVisible(true);
				jt2.setVisible(false);
				bg2.setVisible(false);
				bgl2.setVisible(false);
				bg.setVisible(false);
				bgl.setVisible(false);
			}
			
		});	
	}
	
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
	
	public void formula() throws IOException {

	}
	
	public String getUName() {
		return name;
	}

	public void setUName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static String getUDate() {
		return date;
	}

	public static void setUDate(String date) {
		KibunTest.date = date;
	}

	public void printr() {
		tkp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				String path = System.getProperty("user.home") + File.separator + "results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "results_" + i.toString() + ".txt";
							results = new File(path);
							i++;
					};
						br = new BufferedWriter(new FileWriter(results, true));
						br.write("samplename");
						br.newLine();
						br.write("sampleage");
						br.newLine();
						br.write("samplegender");
						br.newLine();
						br.flush();
						br.close();
						
					JOptionPane.showMessageDialog(contentPane, "File is successfully downloaded. (" + i.toString() + ")");
					
				} catch (IOException e) {
					e.printStackTrace();
				}				
		    }

		});		
	}
	
	public void retake() {
		tkp1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				jbg.clearSelection();
				brp8.setVisible(true);
				brp11.setVisible(false);
				jlp.setVisible(true);	
				jlp3.setVisible(false);
		    }

		});		
	}
	
	public void takeA() {
		tkp2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				KibunTest kt;
				try {
					kt = new KibunTest();
					Thread t1 = new Thread(kt);
			        t1.start();
			        dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		    }

		});		
	}
	
	public void exitSA() {
		tkp3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				System.exit(0);
			}

		});	
	}	
}
