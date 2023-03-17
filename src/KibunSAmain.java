import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

//COLORS
//1: 255,255,240,255
//2: 198,217,191,255
//3: 136,211,152,255
//4: 27,147,111,255
//5: 17,75,95,255

public class KibunSAmain extends JFrame {
	private static JPanel contentPane;
	private String username;
	private String age1;
	private String gender;
	
	private static boolean b1 = false;
	private static boolean b2 = false;
	
//BORDERS
	Border nbord = BorderFactory.createEmptyBorder(5,8,8,8);
	Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);
	Border hbord = BorderFactory.createLineBorder(new Color(198,217,191,255), 2);

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		
			KibunSAmain ks = new KibunSAmain();
			ks.KibunSAhp();
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public KibunSAmain() throws IOException {
		
		JFrame jf = new JFrame();

	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setBounds(250, 150, 800, 450);
		jf.setTitle("Kibun: Self-Assessment App");
		
		jf.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,255,240,255));
		contentPane.setLayout(null);
		jf.setContentPane(contentPane);
		
		JLayeredPane jlp = new JLayeredPane();
		jlp.setLayout(null);
		jlp.setSize(800, 450);
		jlp.setOpaque(false);
		contentPane.add(jlp);
		
//TIMED_INTRO
		Timer time = new Timer(2000, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent ae) {
					try {
						contentPane.add(KibunSAwelp());
					} catch (IOException e) {
						e.printStackTrace();
					}
					jlp.setVisible(false);
	              }
	           });
		time.setRepeats(false);
		time.start();

//PART_1
		File jo = new File("logo.png");
		JPanel jop = getLogo(jo);
		jop.setLocation(325, 55);
		jlp.add(jop, 1);
		
		File br = new File("branda.png");
		JPanel brp = getBrand(br);
		brp.setLocation(275, 165);
		brp.setVisible(true);
		jlp.add(brp, 1);		
	}

	public JPanel getLogo(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(150, 150);
		durp.setOpaque(false);
		
		return durp;
	}
	
	public JPanel getBrand(File tdur) throws IOException
	{
		BufferedImage dur; 
		dur = ImageIO.read(tdur);
		Image resize = dur.getScaledInstance(250, 175, Image.SCALE_SMOOTH);
		JLabel durl = new JLabel(new ImageIcon(resize));
		JPanel durp = new JPanel();
		durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		durp.add(durl);
		durp.setSize(250, 175);
		durp.setOpaque(false);
		
		return durp;	
	}

//PART_2
	public JPanel KibunSAwelp() throws IOException {
		
		JPanel welcome = new JPanel();
		welcome.setBackground(new Color(255,255,240,255));
		welcome.setSize(800, 450);
		welcome.setLayout(null);
		welcome.setLocation(0, 0);
		welcome.setOpaque(true);
		welcome.setVisible(true);
		
		JPanel welcome2 = new JPanel();
		welcome2.setBackground(new Color(255,255,240,255));
		welcome2.setSize(800, 450);
		welcome2.setLayout(null);
		welcome2.setLocation(0, 0);
		welcome2.setOpaque(true);
		welcome2.setVisible(false);
		contentPane.add(welcome2);
		
		JPanel welcome3 = new JPanel();
		welcome3.setBackground(new Color(255,255,240,255));
		welcome3.setSize(800, 450);
		welcome3.setLayout(null);
		welcome3.setLocation(0, 0);
		welcome3.setOpaque(true);
		welcome3.setVisible(false);
		contentPane.add(welcome3);

//NAME_PART
		JTextField jt = uName("enter name");
		jt.setVisible(true);
		welcome.add(jt);
		
		File brw = new File("branda.png");
		JPanel brpw = getBrand(brw);
		brpw.setLocation(275, -10);
		brpw.setVisible(true);
		welcome.add(brpw);
		
		File br2 = new File("how.png");
		JPanel brp2 = getGreet(br2);
		brp2.setLocation(175, 160);
		brp2.setVisible(true);
		welcome.add(brp2);
		
//LONG_GREEN
		File br3 = new File("und.png");
		JPanel brp3 = getULine(br3);
		brp3.setLocation(225, 265);
		brp3.setVisible(true);
		welcome.add(brp3);

//LONG_GREY
		File br4 = new File("und2.png");
		JPanel brp4 = getULine(br4);
		brp4.setLocation(225, 265);
		brp4.setVisible(false);
		welcome.add(brp4);
		
//LONG_RED
		File br7 = new File("und3.png");
		JPanel brp7 = getULine(br7);
		brp7.setLocation(225, 265);
		brp7.setVisible(false);
		welcome.add(brp7);

//NEXT_GREEN
		File br13 = new File("n1.png");
		JPanel brp13 = getBegB(br13);
		brp13.setLocation(355, 315);
		brp13.setVisible(true);
		welcome.add(brp13);
		
//NAME		
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				b1 = true;
				jt.setText("");
				brp13.setVisible(true);
				jt.setForeground(new Color(26,148,111,255));
				jt.setEditable(true);
				brp3.setVisible(false);
				brp4.setVisible(true);
			}
					
			public void mouseEntered(MouseEvent me) {
				jt.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}			
		});
		
//NEXT_NAME
		brp13.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent me) {
				if(!b1)
				{
					new JOptionPane();
					JOptionPane.showMessageDialog(contentPane, "Please enter your name.", "Invalid input", JOptionPane.WARNING_MESSAGE);
				} else {
				if(!isValid(jt.getText())) {
					new JOptionPane();
					JOptionPane.showMessageDialog(contentPane, "Name must only consist of letters.", "Invalid input", JOptionPane.WARNING_MESSAGE);
					jt.setForeground(new Color (192,0,0,255));
					brp3.setVisible(false);
					brp4.setVisible(false);
					brp7.setVisible(true);
				} else {
					setUsername(jt.getText().trim());
					KibunTest.name = username;
					welcome.setVisible(false);
					welcome2.setVisible(true);
				}
			}	
			}
			public void mouseEntered(MouseEvent me) {
				brp13.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

//AGE_PART
		File br = new File("branda.png");
		JPanel brp = getBrand(br);
		brp.setLocation(275, -10);
		brp.setVisible(true);
		welcome2.add(brp);
		
		JTextField age = uAge("14");
		age.setVisible(true);
		welcome2.add(age);
		
		File br16 = new File("old.png");
		JPanel brp16 = getGreet(br16);
		brp16.setLocation(175, 160);
		brp16.setVisible(true);
		welcome2.add(brp16);

		File br213 = new File("n1.png");
		JPanel brp213 = getBegB(br213);
		brp213.setLocation(355, 315);
		brp213.setVisible(true);
		welcome2.add(brp213);	
		
		File bar = new File("bar.png");
		JPanel barp = getBar(bar);
		barp.setVisible(true);
		welcome2.add(barp, 0);
		
		barp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				b1 = true;
				welcome2.setVisible(false);
				welcome.setVisible(true);
			}
					
			public void mouseEntered(MouseEvent me) {
				barp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

//SHORT_GREY
		File br14 = new File("und.png");
		JPanel brp14 = getULine(br14);
		brp14.setSize(75, 50);
		brp14.setLocation(363, 265);
		brp14.setVisible(true);
		welcome2.add(brp14);

//SHORT_GREEN
		File br15 = new File("und2.png");
		JPanel brp15 = getULine(br15);
		brp15.setSize(75, 50);
		brp15.setLocation(363, 265);
		brp15.setVisible(false);
		welcome2.add(brp15);

//SHORT_RED
		File br17 = new File("und3.png");
		JPanel brp17 = getULine(br17);
		brp17.setSize(75, 50);
		brp17.setLocation(363, 265);
		brp17.setVisible(false);
		welcome2.add(brp17);
		
//AGE
		age.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				b2 = true;
				age.setText("");
				brp213.setVisible(true);
				age.setForeground(new Color(26,148,111,255));
				brp14.setVisible(false);
				brp15.setVisible(true);
			}
					
			public void mouseEntered(MouseEvent me) {
				age.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
						
		
//NEXT_AGE
		brp213.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if(!b2)
				{
					new JOptionPane();
					JOptionPane.showMessageDialog(contentPane, "Please enter your age.", "Invalid input", JOptionPane.WARNING_MESSAGE);
				} else {	
				if(isValid3(age.getText()))
				{	
					if(Integer.parseInt(age.getText()) >= 14 && Integer.parseInt(age.getText()) <= 90)
					{
						setAge(age.getText().trim());
						KibunTest.age = age1;
						welcome2.setVisible(false);
						welcome3.setVisible(true);
						age.setForeground(new Color(26,148,111,255));
						brp17.setVisible(false);
						brp15.setVisible(true);
					}
					
					else
					{
						new JOptionPane();
						JOptionPane.showMessageDialog(contentPane, "You must be above 14 and below 90 to enter.", "Age restricted", JOptionPane.WARNING_MESSAGE);
						age.setForeground(new Color(192,0,0,255));
						brp15.setVisible(false);
						brp17.setVisible(true);
					}
				}
			}
			}
			public void mouseEntered(MouseEvent me) {
				brp213.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

//GENDER_PART
		
		File brb = new File("branda.png");
		JPanel brpb = getBrand(brb);
		brpb.setLocation(275, -10);
		brpb.setVisible(true);
		welcome3.add(brpb);
		
		File br161 = new File("are.png");
		JPanel brp161 = getGreet(br161);
		brp161.setLocation(175, 160);
		brp161.setVisible(true);
		welcome3.add(brp161);
		
		File bar2 = new File("bar.png");
		JPanel barp2 = getBar(bar2);
		barp2.setVisible(true);
		welcome3.add(barp2, 0);
		
		barp2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				b2 = true;
				welcome3.setVisible(false);
				welcome2.setVisible(true);
			}
					
			public void mouseEntered(MouseEvent me) {
				barp2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		ButtonGroup fm = new ButtonGroup();
		
		JRadioButton ml = new JRadioButton(" male");
		ml.setSize(105, 50);
		ml.setLocation(260, 225);
		ml.setFont(new Font("Metropolis Black", Font.PLAIN, 28));
		ml.setForeground(new Color(198,218,191,255));
		ml.setOpaque(false);
		ml.setFocusPainted(false);
		fm.add(ml);
		welcome3.add(ml);
		
		JRadioButton fl = new JRadioButton(" female");
		fl.setSize(135, 50);
		fl.setLocation(425, 225);
		fl.setFont(new Font("Metropolis Black", Font.PLAIN, 28));
		fl.setForeground(new Color(198,218,191,255));
		fl.setOpaque(false);
		fl.setFocusPainted(false);
		fm.add(fl);
		welcome3.add(fl);
		
		ml.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				ml.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		fl.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				fl.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		if(fl.isSelected())
		{
			ml.setForeground(new Color(198,218,191,255));
		}
		
		ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ml.setForeground(new Color(27,147,111,255));
				fl.setForeground(new Color(198,218,191,255));
				setGender(ml.getText().trim().substring(0, 1).toUpperCase());
				KibunTest.gender = gender;
			}
		});
		
		fl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fl.setForeground(new Color(27,147,111,255));
				ml.setForeground(new Color(198,218,191,255));
				setGender(fl.getText().trim().substring(0, 1).toUpperCase());
				KibunTest.gender = gender;
			}
		});
		
		File br6 = new File("beginb.png");
		JPanel brp6 = getBegB(br6);
		brp6.setLocation(355, 315);
		brp6.setVisible(true);
		welcome3.add(brp6);


//BEGIN
		brp6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				b1 = false;
				if(fm.getSelection() == null) {
					new JOptionPane();
					JOptionPane.showMessageDialog(contentPane, "Please choose one.", "Invalid input", JOptionPane.WARNING_MESSAGE);
				} else {	
					try {
						KibunTest.date = uDate().getText().substring(14);
						contentPane.removeAll();
						contentPane.revalidate();
						contentPane.repaint();
						contentPane.add(KibunSAhp());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			public void mouseEntered(MouseEvent me) {
				brp6.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		return welcome;
	}
	
//ELEMENTS
	public static boolean isValid3(String s)
	   {
		try{
			int n = Integer.parseInt(s);
			return Boolean.TRUE;
	      }catch(NumberFormatException e){
	    	new JOptionPane();
	    	JOptionPane.showMessageDialog(contentPane, "Age must be a number.", "Invalid input", JOptionPane.WARNING_MESSAGE);
	    	return Boolean.FALSE;
	     }
	   }
	
	public static boolean isValid2(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
	
		public static Boolean isValid(String s)
	    {
			if (s.isBlank())
			{
				return Boolean.FALSE;
			}
			else
			{
				for (int i = 0; i < s.length(); i++)
		        {
		            char c = s.charAt(i);
		            if (!(c >= 'A' && c <= 'Z') &&
		                    !(c >= 'a' && c <= 'z') && !(Character.isWhitespace(c)))
		            {
		                return Boolean.FALSE;
		            }
		        }
			}
	        return Boolean.TRUE;
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
		
		public JTextField uAge(String s)
		{
			

			JTextField jt = new JTextField();
			jt.setText(s);
			jt.setHorizontalAlignment(SwingConstants.CENTER);
			jt.setFont(new Font("Metropolis Black", Font.PLAIN, 28));
			jt.setForeground(new Color(198,218,191,255));
			jt.setOpaque(false);
			jt.setBorder(nobord);
			jt.setBounds(50, 20, 75, 50);
			jt.setLocation(363, 220);
			jt.setCaretColor(getForeground());
			jt.setEditable(true);
			
			return jt;
		}
		
		public JTextField uName(String s)
		{
			JTextField jt = new JTextField();
			jt.setText(s);
			jt.setHorizontalAlignment(SwingConstants.CENTER);
			jt.setFont(new Font("Metropolis Black", Font.PLAIN, 28));
			jt.setForeground(new Color(198,218,191,255));
			jt.setOpaque(false);
			jt.setBorder(nobord);
			jt.setBounds(50, 20, 300, 50);
			jt.setLocation(250, 220);
			jt.setCaretColor(getForeground());
			jt.setEditable(true);
			
			return jt;
		}
		
		public JPanel getULine(File tdur) throws IOException
		{
			BufferedImage dur; 
			dur = ImageIO.read(tdur);
			Image resize = dur.getScaledInstance(250, 7, Image.SCALE_SMOOTH);
			JLabel durl = new JLabel(new ImageIcon(resize));
			JPanel durp = new JPanel();
			durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			durp.add(durl);
			durp.setSize(350, 50);
			durp.setOpaque(false);
			
			return durp;
			
		}
		
		public JPanel getGreet(File tdur) throws IOException
		{
			BufferedImage dur; 
			dur = ImageIO.read(tdur);
			Image resize = dur.getScaledInstance(450, 65, Image.SCALE_SMOOTH);
			JLabel durl = new JLabel(new ImageIcon(resize));
			JPanel durp = new JPanel();
			durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			durp.add(durl);
			durp.setSize(450, 65);
			durp.setOpaque(false);
			
			return durp;
			
		}

//PART_3
		public JLayeredPane KibunSAhp() throws IOException {
			
			JLayeredPane home = new JLayeredPane();
			home.setBackground(new Color(255,255,240,255));
			home.setSize(800, 450);
			home.setLayout(null);
			home.setLocation(0, 0);
			home.setOpaque(true);
			home.setVisible(true);
			
			JTextField dt = uDate();
			dt.setLocation(580, 75);
			home.add(dt, 0);
			
			JTextField jt = uName();
			jt.setLocation(125, 75);
			home.add(jt, 0);
			
			File br1 = new File("header.png");
			JPanel brp1 = getHLine(br1);
			brp1.setLocation(0,-15);
			brp1.setVisible(true);
			home.add(brp1, 1);
			
			File br2 = new File("hi.png");
			JPanel brp2 = getHi(br2);
			brp2.setLocation(70,72);
			brp2.setVisible(true);
			home.add(brp2, 0);
			
			File br3 = new File("these.png");
			JPanel brp3 = getThese(br3);
			brp3.setLocation(107,110);
			brp3.setVisible(true);
			home.add(brp3, 0);	
			
			File br4 = new File("logout.png");
			JPanel brp4 = getLogB(br4);
			brp4.setLocation(725,15);
			brp4.setVisible(true);
			home.add(brp4, 0);
			
			File br12 = new File("rec.png");
			JPanel brp12 = getRecB(br12);
			brp12.setLocation(30,15);
			brp12.setVisible(true);
			home.add(brp12, 0);
			
			
			String[] options = new String[] {"Depression Anxiety Stress Scale",
					"Kessler Psychological Distress Scale",
					"Perceived Stress Scale",
					"Buss-Perry Aggression Questionnaire",
					"The Epworth Sleepiness Scale",
					"Open Hemispheric Brain Dominance Scale",
					"Brief-COPE",
					"Rosenberg Self-Esteem Scale"
			};
			
			DefaultListModel dlm = new DefaultListModel();
			
			JList rec1 = new JList(dlm);
			rec1.setBorder(nbord);
			rec1.setForeground(new Color (27,147,111,255));
			rec1.setBackground(new Color (255,255,240,255));
			JScrollPane jsp = new JScrollPane(rec1);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jsp.setBounds(70, 15, 260, 100);
			jsp.setBorder(hbord);
			jsp.setVisible(false);
			home.add(jsp, 0);

			brp12.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					jsp.setVisible(true);
				}
				
				public void mouseExited(MouseEvent me) {
					jsp.setVisible(false);
				}
			});
			
			brp4.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					brp4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				public void mouseClicked(MouseEvent me) {
					try {
						contentPane.removeAll();
						contentPane.revalidate();
						contentPane.repaint();
						contentPane.add(KibunSAwelp());
					} catch (IOException e) {
						e.printStackTrace();
					}
					 
				}
				
			});
			
//PAGE_1
			ButtonGroup gp = new ButtonGroup();
			JToggleButton op1 = getBut("Depression Anxiety Stress Scale (DASS-21)");
			JToggleButton op2 = getBut("Kessler Psychological Distress Scale (K10)");
			JToggleButton op3 = getBut("Perceived Stress Scale (PSS)");
			JToggleButton op4 = getBut("Buss-Perry Aggression Questionnaire (BPAQ)");
			gp.add(op1);
			gp.add(op2);
			gp.add(op3);
			gp.add(op4);

			JPanel page1 = new JPanel();
			page1.setLayout(null);
			page1.setSize(460, 175);
			page1.setLocation(165, 155);
			page1.setOpaque(false);
			home.add(page1);
			
//option_1
			op1.setLocation(5, 5);
			page1.add(op1);
			
			op1.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op1.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op1.setBackground(new Color(27,147,111,255));
					op1.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op1.setForeground(new Color(255,255,240,255));
					op1.setBackground(new Color(136,211,152,255));
				}
			
		});	
			
			op1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option1 ex1 = new Option1();
					gp.clearSelection();
					dlm.addElement(options[0]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});
			
//option_2
			op2.setLocation(5, 50);
			page1.add(op2);
			
			op2.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op2.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op2.setBackground(new Color(27,147,111,255));
					op2.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op2.setForeground(new Color(255,255,240,255));
					op2.setBackground(new Color(136,211,152,255));
				}
			
		});	
			op2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option2 ex2 = new Option2();
					gp.clearSelection();
					dlm.addElement(options[1]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});
			
//option_3
			op3.setLocation(5, 95);
			page1.add(op3);
			
			op3.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op3.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op3.setBackground(new Color(27,147,111,255));
					op3.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op3.setForeground(new Color(255,255,240,255));
					op3.setBackground(new Color(136,211,152,255));
				}
			
		});
			
			op3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option3 ex3 = new Option3();
					gp.clearSelection();
					dlm.addElement(options[2]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});
			
//option_4
			op4.setLocation(5, 140);
			page1.add(op4);
			
			op4.addMouseListener(new MouseAdapter() {
				
					public void mouseEntered(MouseEvent me) {
						op4.setCursor(new Cursor(Cursor.HAND_CURSOR));
						op4.setBackground(new Color(27,147,111,255));
						op4.setForeground(new Color(255,255,240,255));
					}
					
					public void mouseExited(MouseEvent me) {
						op4.setForeground(new Color(255,255,240,255));
						op4.setBackground(new Color(136,211,152,255));
					}
				
			});	
			
			op4.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option4 ex4 = new Option4();
					gp.clearSelection();
					dlm.addElement(options[3]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});

//PAGE_2
			JToggleButton op5 = getBut("The Epworth Sleepiness Scale (ESS)");
			JToggleButton op6 = getBut("Open Hemispheric Brain Dominance Scale");
			JToggleButton op7 = getBut("Brief-COPE (Brief-COPE)");
			JToggleButton op8 = getBut("Rosenberg Self-Esteem Scale (RSES)");
			
			gp.add(op5);
			gp.add(op6);
			gp.add(op7);
			gp.add(op8);
			
			JPanel page2 = new JPanel();
			page2.setLayout(null);
			page2.setSize(460, 175);
			page2.setLocation(165, 155);
			page2.setOpaque(false);
			home.add(page2);

//option_5
			op5.setLocation(5, 5);
			page2.add(op5);
			
			op5.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op5.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op5.setBackground(new Color(27,147,111,255));
					op5.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op5.setForeground(new Color(255,255,240,255));
					op5.setBackground(new Color(136,211,152,255));
				}
			
		});		
			
			op5.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option5 ex5 = new Option5();
					gp.clearSelection();
					dlm.addElement(options[4]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});

//option_6
			op6.setLocation(5, 50);
			page2.add(op6);
			
			op6.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op6.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op6.setBackground(new Color(27,147,111,255));
					op6.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op6.setForeground(new Color(255,255,240,255));
					op6.setBackground(new Color(136,211,152,255));
				}
			
		});	
			
			op6.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option6 ex6 = new Option6();
					gp.clearSelection();
					dlm.addElement(options[5]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});

//option_7
			op7.setLocation(5, 95);
			page2.add(op7);
			
			op7.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op7.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op7.setBackground(new Color(27,147,111,255));
					op7.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op7.setForeground(new Color(255,255,240,255));
					op7.setBackground(new Color(136,211,152,255));
				}
			
		});
			
			op7.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option7 ex7 = new Option7();
					gp.clearSelection();
					dlm.addElement(options[6]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});

//option_8
			op8.setLocation(5, 140);
			page2.add(op8);
			
			op8.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent me) {
					op8.setCursor(new Cursor(Cursor.HAND_CURSOR));
					op8.setBackground(new Color(27,147,111,255));
					op8.setForeground(new Color(255,255,240,255));
				}
				
				public void mouseExited(MouseEvent me) {
					op8.setForeground(new Color(255,255,240,255));
					op8.setBackground(new Color(136,211,152,255));
				}
			
		});		
			
			op8.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){  
		           try {
					Option8 ex8 = new Option8();
					gp.clearSelection();
					dlm.addElement(options[7]);
					rec1.ensureIndexIsVisible(dlm.size()-1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}  
	});
			
			
	//NAVIGATE_PAGE
			JTextField jt1 = uNext("next page >");
			jt1.setLocation(575, 360);
			jt1.setSize(90, 15);
			home.add(jt1);
			
			JTextField jt2 = uNext("< previous page");
			jt2.setForeground(new Color(198,217,191,255));
			jt2.setLocation(95, 360);
			home.add(jt2);
			
			page1.setVisible(true);
			page2.setVisible(false);	

	//next_button
			jt1.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					if (page1.isVisible())
						jt1.setCursor(new Cursor(Cursor.HAND_CURSOR));
					else
						jt1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						
				}
				
				public void mouseClicked(MouseEvent me) {
					page1.setVisible(false);
					page2.setVisible(true);
					jt1.setForeground(new Color(198,217,191,255));
					jt2.setForeground(new Color(26,148,111,255));
				}
				
			});

	//previous_button
			jt2.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					if (page2.isVisible())
						jt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
					else
						jt2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				
				public void mouseClicked(MouseEvent me) {
					page1.setVisible(true);
					page2.setVisible(false);
					jt1.setForeground(new Color(26,148,111,255));
					jt2.setForeground(new Color(198,217,191,255));
				}
				
			});
			
			return home;
		}
		
//ELEMENTS
		
		public JPanel getBar(File tdur) throws IOException
		{
			BufferedImage dur; 
			dur = ImageIO.read(tdur);
			Image resize = dur.getScaledInstance(15, 20, Image.SCALE_SMOOTH);
			JLabel durl = new JLabel(new ImageIcon(resize));
			JPanel durp = new JPanel();
			durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			durp.add(durl);
			durp.setSize(15, 20);
			durp.setLocation(315, 322);
			durp.setOpaque(false);
			
			return durp;
		} 
		
		public JTextField uDate() throws IOException
		{
			Border nobord = BorderFactory.createEmptyBorder(2,10,0,0);
			
			JTextField jt = new JTextField();
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("EEE, MMM dd YYYY");
			LocalDate today = LocalDate.now();
			jt.setText("Today is " + dt.format(today));
			jt.setHorizontalAlignment(SwingConstants.LEFT);
			jt.setFont(new Font("Metropolis Medium", Font.PLAIN, 12));
			jt.setForeground(new Color(255,255,240,255));
			jt.setBackground(new Color(27,147,111,255));
			jt.setOpaque(true);
			jt.setBorder(nobord);
			jt.setSize(250, 20);
			jt.setLocation(250, 220);
			jt.setEditable(false);
			
			return jt;
		}
		
		public JToggleButton getBut(String s)
		{
			Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);

			JToggleButton jb = new JToggleButton();
			jb.setText(s);
			jb.setHorizontalAlignment(SwingConstants.CENTER);
			jb.setFont(new Font("Metropolis Medium", Font.PLAIN, 18));
			jb.setBackground(new Color(136,211,152,255));
			jb.setForeground(new Color(255,255,240,255));
			jb.setFocusPainted(false);
			jb.setBorder(nobord);
			jb.setSize(450, 30);
			
			return jb;
		}
		
		public JTextField uNext(String s) throws IOException
		{
			Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);

			JTextField jt = new JTextField();
			jt.setText(s);
			jt.setHorizontalAlignment(SwingConstants.CENTER);
			jt.setFont(new Font("Metropolis Black", Font.PLAIN, 14));
			jt.setForeground(new Color(26,148,111,255));
			jt.setOpaque(false);
			jt.setBorder(nobord);
			jt.setSize(120, 15);
			jt.setLocation(250, 220);
			jt.setCaretColor(getForeground());
			jt.setEditable(false);
			
			return jt;
		}
		
		public JPanel getThese(File tdur) throws IOException
		{
			BufferedImage dur; 
			dur = ImageIO.read(tdur);
			Image resize = dur.getScaledInstance(395, 44, Image.SCALE_SMOOTH);
			JLabel durl = new JLabel(new ImageIcon(resize));
			JPanel durp = new JPanel();
			durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			durp.add(durl);
			durp.setSize(395, 44);
			durp.setOpaque(false);
			
			return durp;
		} 
		
		public JPanel getRecB(File tdur) throws IOException
		{
			BufferedImage dur; 
			dur = ImageIO.read(tdur);
			Image resize = dur.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			JLabel durl = new JLabel(new ImageIcon(resize));
			JPanel durp = new JPanel();
			durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			durp.add(durl);
			durp.setSize(30, 30);
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
		
		public JPanel getHi(File tdur) throws IOException
		{
			BufferedImage dur; 
			dur = ImageIO.read(tdur);
			Image resize = dur.getScaledInstance(65, 60, Image.SCALE_SMOOTH);
			JLabel durl = new JLabel(new ImageIcon(resize));
			JPanel durp = new JPanel();
			durp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			durp.add(durl);
			durp.setSize(65, 60);
			durp.setOpaque(false);
			
			return durp;
		} 
		
		public JTextField uName() throws IOException
		{
			Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);
			
			String s = username;
			JTextField jt = new JTextField();
			jt.setText(s);
			jt.setHorizontalAlignment(SwingConstants.LEFT);
			jt.setFont(new Font("Metropolis Black", Font.PLAIN, 28));
			jt.setForeground(new Color(26,148,111,255));
			jt.setOpaque(false);
			jt.setBorder(nobord);
			jt.setBounds(50, 20, 300, 50);
			jt.setLocation(250, 220);
			jt.setCaretColor(getForeground());
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

			public void setUsername(String s) {
				username = s;
			}
			
			public void setAge(String s) {
				age1 = s;
			}
			
			public void setGender(String s) {
				gender = s;
			}


	
}
