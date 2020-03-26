import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI {

    private JFrame frame;
    private JTextField allVertices;
    private JTextArea textField_1;
    public String out = "";
    public static Vector<Vertix> vertices = new Vector<Vertix>();
    public static Vector<Edge> edges = new Vector<Edge>();
    private JTextField edgeValue;
    private JTextField edgeStart;
    private JTextField edgeEnd;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setEnabled(false);
        frame.setResizable(false);
        frame.setBounds(100, 100, 1149, 505);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lblNewLabel_1 = new JLabel("Please enter the value of each edge :");
        textField_1 = new JTextArea(out);
        textField_1.setColumns(10);
        this.textField_1.setText(out);

        JLabel lblNewLabel = new JLabel("Please enter all the vertices with spaces between them :");

        allVertices = new JTextField();
        allVertices.setColumns(10);
        minimum_spanning_tree tree = new minimum_spanning_tree();
        JButton compress = new JButton("Press me for the Output");
        compress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = allVertices.getText();
                out = tree.main(vertices, edges);
                textField_1.setText(out);
            }
        });

        JButton verticesBtn = new JButton("Press here after entering all the vertices");
        verticesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vertex = allVertices.getText();
                String str = "";
                vertices.clear();
                edges.clear();
                for(int i = 0 ; i < vertex.length() ; i++) {
                    if(vertex.charAt(i) == ' ')
                        continue;
                    while (i < vertex.length() && vertex.charAt(i) != ' ') {
                        str += vertex.charAt(i);
                        i++;
                    }
                    Vertix v = new Vertix(str);
                    vertices.add(v);
                    str = "";
                }
            }
        });

        edgeValue = new JTextField();
        edgeValue.setColumns(10);

        JLabel lblItConnectsBetween = new JLabel("It connects between :");

        edgeStart = new JTextField();
        edgeStart.setColumns(10);

        JLabel lblAnd = new JLabel("And :");

        edgeEnd = new JTextField();
        edgeEnd.setColumns(10);

        JButton btnPressHereAfter = new JButton("Press here after entering edge's data");
        btnPressHereAfter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Integer value = Integer.parseInt(edgeValue.getText());
                boolean ss = false;
                boolean ee = false;
            	Edge edge = new Edge();
                edge.value = Integer.parseInt(edgeValue.getText());
                //edge.start = getVertix(edgeStart.getText());
                //edge.end = getVertix(edgeEnd.getText());
                for(int i = 0 ; i < vertices.size(); i++) {
                    if(vertices.elementAt(i).name.equals(edgeStart.getText())) {
                        edge.start = vertices.elementAt(i);
                        ss = true;
                    }
                }
                for(int i = 0 ; i < vertices.size(); i++) {
                    if(vertices.elementAt(i).name.equals(edgeEnd.getText())) {
                        edge.end = vertices.elementAt(i);
                		ee = true;
                	}
                }
                if(ss && ee)	
                	edges.add(edge);
            }
        });
        this.textField_1.setText(out);
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(34)
                                .addComponent(lblNewLabel)
                                .addGap(18)
                                .addComponent(allVertices, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                .addGap(31)
                                .addComponent(verticesBtn, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(34)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                .addGap(60)
                                .addComponent(lblItConnectsBetween, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addGap(29)
                                .addComponent(lblAnd, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(34)
                                .addComponent(edgeValue, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addGap(118)
                                .addComponent(edgeStart, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addGap(29)
                                .addComponent(edgeEnd, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addGap(31)
                                .addComponent(btnPressHereAfter, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(176)
                                .addComponent(compress, GroupLayout.PREFERRED_SIZE, 805, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(34)
                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(25)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(lblNewLabel))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(allVertices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(verticesBtn))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(lblItConnectsBetween)
                                        .addComponent(lblAnd))
                                .addGap(11)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(edgeValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(edgeStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(edgeEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnPressHereAfter))
                                .addGap(35)
                                .addComponent(compress)
                                .addGap(18)
                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
        );
        frame.getContentPane().setLayout(groupLayout);
    }
}
