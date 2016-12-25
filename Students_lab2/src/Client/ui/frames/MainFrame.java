package Client.ui.frames;

import Client.ui.cellEditors.GrouptCellEditor;
import Client.ui.cellEditors.StudentCellEditor;
import Client.ui.listeners.*;
import Client.ui.renderers.GroupRenderer;
import Client.ui.renderers.StudentRenderer;
import Client.Root;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.DataOutputStream;
import java.util.Calendar;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class MainFrame extends JFrame{

    public JTable studentsTable;
    public JTable groupsTable;
    public Root root;
    public DataOutputStream out;
    public static int countOfFrames = 0;


    public MainFrame(Root root, DataOutputStream out){

        super("ASO University");
        countOfFrames++;
        this.out = out;
        this.root = root;
        JPanel downPannel = new JPanel();
        downPannel.setLayout(new BoxLayout(downPannel, BoxLayout.X_AXIS));
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new RefreshListener(out));
        downPannel.add(refreshButton);

        JPanel centralPannel = new JPanel();
        centralPannel.setLayout(new BoxLayout(centralPannel, BoxLayout.X_AXIS));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultTableModel dm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return arg1 >= 5;
            }
        };


        Object [][] students = new Object[root.getStudentModelList().size()][6];

        for (int i = 0; i <root.getStudentModelList().size(); i++) {

            students[i][0] = root.getStudentModelList().get(i).getSurname();
            students[i][1] = root.getStudentModelList().get(i).getName();
            students[i][2] = root.getStudentModelList().get(i).getPatronymic();
            final int j=i;
            students[i][3] = root.getGroupModelList().stream().filter(groupModel -> groupModel.getIdOfGroup()==root.getStudentModelList().get(j).getGroupId()).findFirst().get().getNumberOfGroup();
            students[i][4] = root.getStudentModelList().get(i).getDateOfEnrollment().get(Calendar.YEAR)+"."+(root.getStudentModelList().get(i).getDateOfEnrollment().get(Calendar.MONTH)+1)+"."+root.getStudentModelList().get(i).getDateOfEnrollment().get(Calendar.DAY_OF_MONTH);
            students[i][5] = new JRadioButton();

        }
        dm.setDataVector(students, new Object[]{"Surname", "Name", "Patronymic", "Group", "date of environment", "Choice"});


        studentsTable = new JTable(dm){

            public void tableChanged(TableModelEvent e){
                super.tableChanged(e);
                repaint();
            }
        };

        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i <root.getStudentModelList().size(); i++) {

            bg.add((JRadioButton)dm.getValueAt(i,5));
        }

        studentsTable.getColumn("Choice").setCellRenderer(new StudentRenderer());
        studentsTable.getColumn("Choice").setCellEditor(new StudentCellEditor(new JCheckBox(), studentsTable));

        JScrollPane pane = new JScrollPane(studentsTable);

        DefaultTableModel dm1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return arg1 >= 2;
            }
        };

        Object [][] groups = new Object[root.getGroupModelList().size()][3];
        for (int i = 0; i <root.getGroupModelList().size(); i++) {

            groups[i][0] = root.getGroupModelList().get(i).getNumberOfGroup();
            groups[i][1] = root.getGroupModelList().get(i).getNameOfFaculty();
            groups[i][2] = new JRadioButton();

        }
        dm1.setDataVector(groups, new Object[]{"Name", "Faculty", "Choice"});

        groupsTable = new JTable(dm1){

            public void tableChanged(TableModelEvent e){
                super.tableChanged(e);
                repaint();
            }
        };

        ButtonGroup bg1 = new ButtonGroup();
        for (int i = 0; i <root.getGroupModelList().size(); i++) {

            bg1.add((JRadioButton)dm1.getValueAt(i,2));
        }
        groupsTable.getColumn("Choice").setCellRenderer(new GroupRenderer());
        groupsTable.getColumn("Choice").setCellEditor(new GrouptCellEditor(new JCheckBox(), groupsTable));

        JScrollPane pane1 = new JScrollPane(groupsTable);

        centralPannel.add(pane);
        centralPannel.add(pane1);

        JPanel buttonsLeftPanel = new JPanel();

        JButton addStudentButton = new JButton("Add student");
        addStudentButton.addActionListener(new AddButtonListener(studentsTable, out, root.getGroupModelList()));
        JButton deleteStudentButton = new JButton("Delete student");
        deleteStudentButton.addActionListener(new DeleteButtonListener(studentsTable, groupsTable, root.getStudentModelList(), root.getGroupModelList(), out));
        JButton editStudentButton = new JButton("Edit student");
        editStudentButton.addActionListener(new EdditionButtonListener(studentsTable, out, root.getStudentModelList(), root.getGroupModelList()));
        JButton searchStudForName = new JButton("Search student for name");
        searchStudForName.addActionListener(new SearchListener(out));
        JButton searchStudForSurname = new JButton("Search student for surname");
        searchStudForSurname.addActionListener(new SearchListener(out));
        JButton searchStudForpatro = new JButton("Search student for patronymic");
        searchStudForpatro.addActionListener(new SearchListener(out));
        JButton searchStudForDate = new JButton("Search student for date of environment");
        searchStudForDate.addActionListener(new SearchListener(out));

        buttonsLeftPanel.setLayout(new GridLayout(15,1));

        buttonsLeftPanel.add(addStudentButton);
        buttonsLeftPanel.add(deleteStudentButton);
        buttonsLeftPanel.add(editStudentButton);
        buttonsLeftPanel.add(searchStudForName);
        buttonsLeftPanel.add(searchStudForSurname);
        buttonsLeftPanel.add(searchStudForpatro);
        buttonsLeftPanel.add(searchStudForDate);

        JPanel buttonsRightPanel = new JPanel();

        JButton addGroupButton = new JButton("Add group");
        addGroupButton.addActionListener(new AddButtonListener(groupsTable, out, root.getGroupModelList()));
        JButton deleteGroupButton = new JButton("Delete group");
        deleteGroupButton.addActionListener(new DeleteButtonListener(studentsTable, groupsTable, root.getStudentModelList(), root.getGroupModelList(), out));
        JButton editGroupButton = new JButton("Edit group");
        editGroupButton.addActionListener(new EdditionButtonListener(groupsTable, out, root.getStudentModelList(), root.getGroupModelList()));
        JButton searchGroupForName = new JButton("Search group for name");
        searchGroupForName.addActionListener(new SearchListener(out));
        JButton searchGroupForSurname = new JButton("Search group for faculty");
        searchGroupForSurname.addActionListener(new SearchListener(out));
        buttonsRightPanel.setLayout(new GridLayout(15,1));

        buttonsRightPanel.add(addGroupButton);
        buttonsRightPanel.add(deleteGroupButton);
        buttonsRightPanel.add(editGroupButton);
        buttonsRightPanel.add(searchGroupForName);
        buttonsRightPanel.add(searchGroupForSurname);

        getContentPane().add(centralPannel, BorderLayout.CENTER);
        getContentPane().add(buttonsRightPanel, BorderLayout.EAST);
        getContentPane().add(buttonsLeftPanel, BorderLayout.WEST);
        getContentPane().add(downPannel, BorderLayout.SOUTH);

        groupsTable.getColumnModel().getColumn(0).setMaxWidth(45);
        groupsTable.getColumnModel().getColumn(2).setMaxWidth(55);

        studentsTable.getColumnModel().getColumn(3).setMaxWidth(45);
        studentsTable.getColumnModel().getColumn(5).setMaxWidth(55);
        studentsTable.getColumnModel().getColumn(4).setMaxWidth(65);

        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();

        setSize(sSize.width,500);
    }
}
