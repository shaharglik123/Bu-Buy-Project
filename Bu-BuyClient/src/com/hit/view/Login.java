package com.hit.view;
import javax.swing.*;
import com.google.gson.Gson;
import com.hit.model.Customer;
import com.hit.model.Request;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Login extends JPanel implements ActionListener{
	char[] inputPass;
	static GraphicView view;
	Request<?> login;
	static String inputid;
		    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private static String OK = "ok";
		    private static String HELP = "help";
		    private JFrame controllingFrame; //needed for dialogs
		    private JPasswordField passwordField;
		    private JTextField userIdText;
		    boolean isCorrect=false;

		    public Login(GraphicView view) {
		    	Login.view=view;

		        //Create everything.
		        userIdText=new JTextField(10);
		        userIdText.setActionCommand(OK);
		        userIdText.addActionListener(this);
		        passwordField = new JPasswordField(10);
		        passwordField.setActionCommand(OK);
		        passwordField.addActionListener(this);

		        JLabel userIdLabel = new JLabel("Enter the username: ");
		        userIdLabel.setLabelFor(userIdLabel);
		        JLabel passwordLabel = new JLabel("Enter the password: ");
		        passwordLabel.setLabelFor(passwordField);

		        JComponent buttonPane = createButtonPanel();

		        //Lay out everything.
		        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		        textPane.add(userIdLabel);
		        textPane.add(userIdText);
		        textPane.add(passwordLabel);
		        textPane.add(passwordField);

		        add(textPane);
		        add(buttonPane);
		    }

		    protected JComponent createButtonPanel() {
		        JPanel p = new JPanel(new GridLayout(0,1));
		        JButton okButton = new JButton("OK");
		        JButton helpButton = new JButton("Help");

		        okButton.setActionCommand(OK);
		        helpButton.setActionCommand(HELP);
		        okButton.addActionListener(this);
		        helpButton.addActionListener(this);

		        p.add(okButton);
		        p.add(helpButton);

		        return p;
		    }

		    public void actionPerformed(ActionEvent e) {
		        String cmd = e.getActionCommand();
		        
		        if (OK.equals(cmd)) { //Process the user.
		            String inputId = userIdText.getText();
		            char[] inputPass = passwordField.getPassword();
		            
		            if (isUserNameAndPassCorrect(inputId,inputPass)) {
		                JOptionPane.showMessageDialog(controllingFrame,
		                    "User and password is correct \n "
		                    + "              Welcome");
		                view.logingAccepted();
		            } else {
		                JOptionPane.showMessageDialog(controllingFrame,
		                    "Invalid password. Try again.",
		                    "Error Message",
		                    JOptionPane.ERROR_MESSAGE);
		            }

		            //Zero out the possible password, for security.
		            Arrays.fill(inputPass, '0');

		            passwordField.selectAll();
		            resetFocus();
		        } else { //The user has asked for help.
		            JOptionPane.showMessageDialog(controllingFrame,
		                "You can get the password by searching this example's\n"
		              + "source code for the string \"correctPassword\".\n"
		              + "Or look at the section How to Use Password Fields in\n"
		              + "the components section of The Java Tutorial.");
		        }
		    }

		    /**
		     * Checks the passed-in array against the correct password.
		     * After this method returns, you should invoke eraseArray
		     * on the passed-in array.
		     * @param inputName 
		     */
		    private static boolean isUserNameAndPassCorrect(String inputId, char[] inputPass) {
		    	inputid=inputId;
		    	Gson gson = null;
		        String inputPassString = null;
		        try {
		        	inputPassString = String.valueOf(inputPass);
				} catch (NumberFormatException e) {
					System.out.println("cudnt converts char[] to stream");
				}  
		        
		        int id;
		        try {
		        	id=Integer.parseInt(inputId);
		        	if(inputId.equals("")||inputId==null||inputPassString.equals("")||inputPassString==null)
		        		return false;
		        gson=new Gson();
		        Request<Customer> login=new Request<>();
		        Customer cust=new Customer();
		        cust.setId(id);
		        cust.setPassword(inputPassString);
		        login.setBody(cust);
		        login.getHeader().setAction("Login");
		        login.getHeader().setTarget("customer");
		        String loginRequest=gson.toJson(login);
		        System.out.println(login);
		        
		        if (!view.Login(loginRequest)) {
		            System.err.println("password or id is wrong");
		            return false;
		        } else {
		        	System.err.println("User connected");
		        	return true;
		        }
		    }catch (Exception e) {
		    	System.err.println("ID is not an integer try entring you ID again");
				e.printStackTrace();
			}
				return false;
		    }
		    //Must be called from the event dispatch thread.
		    public void resetFocus() {
		        passwordField.requestFocusInWindow();
		    }

		    public int getidlogin() {
		    	return Integer.parseInt(inputid);
		    }

		    
		}