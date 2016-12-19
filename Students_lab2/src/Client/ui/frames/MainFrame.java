package Client.ui.frames;

import Client.ui.cellEditors.GrouptCellEditor;
import Client.ui.cellEditors.StudentCellEditor;
import Client.ui.listeners.AddButtonListener;
import Client.ui.listeners.EdditionButtonListener;
import Client.ui.listeners.SearchListener;
import Client.ui.renderers.GroupRenderer;
import Client.ui.renderers.StudentRenderer;
import Server.Model.Root;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class MainFrame extends JFrame{

    public JTable studentsTable;
    public JTable groupsTable;
    public Root root;


    public MainFrame(Root root){

        super("ASO University");
        this.root = root;
        JPanel downPannel = new JPanel();
        downPannel.setLayout(new BoxLayout(downPannel, BoxLayout.X_AXIS));
        JButton saveDataButton = new JButton("Save data");
        JButton loadDataButton = new JButton("Load data");
        JButton refreshButton = new JButton("Refresh");
        JButton AddDataFromAnotherFileButton = new JButton("Add data from another file");
        downPannel.add(saveDataButton);
        downPannel.add(loadDataButton);
        downPannel.add(AddDataFromAnotherFileButton);
        downPannel.add(refreshButton);

        JPanel centralPannel = new JPanel();
        centralPannel.setLayout(new BoxLayout(centralPannel, BoxLayout.X_AXIS));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultTableModel dm = new DefaultTableModel();
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

        DefaultTableModel dm1 = new DefaultTableModel();
        Object [][] groups = new Object[root.getGroupModelList().size()][3];
        for (int i = 0; i <root.getStudentModelList().size(); i++) {

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

        JPanel buttonsRightPanel = new JPanel();

        JButton addStudentButton = new JButton("Add student");
        addStudentButton.addActionListener(new AddButtonListener(studentsTable));
        JButton deleteStudentButton = new JButton("Delete student");
        JButton editStudentButton = new JButton("Edit student");
        editStudentButton.addActionListener(new EdditionButtonListener(studentsTable));
        JButton searchStudForName = new JButton("Search student for name");
        searchStudForName.addActionListener(new SearchListener());
        JButton searchStudForSurname = new JButton("Search student for surname");
        searchStudForSurname.addActionListener(new SearchListener());
        JButton searchStudForpatro = new JButton("Search student for patronymic");
        searchStudForpatro.addActionListener(new SearchListener());
        JButton searchStudForDate = new JButton("Search student for date of environment");
        searchStudForDate.addActionListener(new SearchListener());

        buttonsRightPanel.setLayout(new BoxLayout(buttonsRightPanel, BoxLayout.Y_AXIS));

        buttonsRightPanel.add(addStudentButton);
        buttonsRightPanel.add(deleteStudentButton);
        buttonsRightPanel.add(editStudentButton);
        buttonsRightPanel.add(searchStudForName);
        buttonsRightPanel.add(searchStudForSurname);
        buttonsRightPanel.add(searchStudForpatro);
        buttonsRightPanel.add(searchStudForDate);

        JPanel buttonsLeftPanel = new JPanel();

        JButton addGroupButton = new JButton("Add group");
        addGroupButton.addActionListener(new AddButtonListener(groupsTable));
        JButton deleteGroupButton = new JButton("Delete group");
        JButton editGroupButton = new JButton("Edit group");
        editGroupButton.addActionListener(new EdditionButtonListener(groupsTable));
        JButton searchGroupForName = new JButton("Search group for name");
        searchGroupForName.addActionListener(new SearchListener());
        JButton searchGroupForSurname = new JButton("Search group for surname");
        searchGroupForSurname.addActionListener(new SearchListener());
        JButton searchGroupForpatro = new JButton("Search group for patronymic");
        searchGroupForpatro.addActionListener(new SearchListener());
        JButton searchGroupForDate = new JButton("Search group for date of environment");
        searchGroupForDate.addActionListener(new SearchListener());

        buttonsLeftPanel.setLayout(new BoxLayout(buttonsLeftPanel, BoxLayout.Y_AXIS));

        buttonsLeftPanel.add(addGroupButton);
        buttonsLeftPanel.add(deleteGroupButton);
        buttonsLeftPanel.add(editGroupButton);
        buttonsLeftPanel.add(searchGroupForName);
        buttonsLeftPanel.add(searchGroupForSurname);
        buttonsLeftPanel.add(searchGroupForpatro);
        buttonsLeftPanel.add(searchGroupForDate);

        getContentPane().add(centralPannel, BorderLayout.CENTER);
        getContentPane().add(buttonsRightPanel, BorderLayout.WEST);
        getContentPane().add(buttonsLeftPanel, BorderLayout.EAST);
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
