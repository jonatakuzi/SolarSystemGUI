import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;

public class SolarSystemApp {
    private JFrame frame;
    private JLabel bigNameLabel;
    private JTable table;
    private DefaultTableModel model;
    private JTextArea descriptionArea;
    private JComboBox<SolarSystemStar> chooserBox;
    private Timer spinner;
    private final Random rng = new Random();
    private SolarSystemStar selected = SolarSystemStar.Earth; // default

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SolarSystemApp().createAndShow());
    }

    private void createAndShow() {
        frame = new JFrame("Solar System – Workshop 4 Starter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(8, 8));

        frame.add(buildCenterPanel(), BorderLayout.CENTER);
        frame.add(buildRightPanel(),  BorderLayout.EAST);
        frame.add(buildBottomControls(), BorderLayout.SOUTH);
        frame.add(buildLeftPanel(),   BorderLayout.WEST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        startSpinner();
        updateSelection(selected);
    }

    private JPanel buildCenterPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(BorderFactory.createTitledBorder("StarPanel (center)"));
        bigNameLabel = new JLabel("—", SwingConstants.CENTER);
        bigNameLabel.setFont(bigNameLabel.getFont().deriveFont(Font.BOLD, 28f));
        p.add(bigNameLabel);
        p.setPreferredSize(new Dimension(360, 240));
        return p;
    }

    private JPanel buildLeftPanel() {
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(BorderFactory.createTitledBorder("Focus / Message"));
        JLabel tip = new JLabel("Use buttons or dropdown →");
        tip.setAlignmentX(Component.LEFT_ALIGNMENT);
        left.add(tip);

        chooserBox = new JComboBox<>(SolarSystemStar.values());
        chooserBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        chooserBox.addActionListener(e ->
                updateSelection((SolarSystemStar) chooserBox.getSelectedItem()));
        left.add(Box.createVerticalStrut(8));
        left.add(chooserBox);

        left.setPreferredSize(new Dimension(220, 240));
        return left;
    }

    private JPanel buildRightPanel() {
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createTitledBorder("Facts + Description"));

        String[] columns = {"#", "Name", "Mass (kg)", "Radius (km)"};
        model = new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        int id = 1;
        for (SolarSystemStar s : SolarSystemStar.values()) {
            model.addRow(s.toRow(id++));
        }
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        table.setPreferredScrollableViewportSize(new Dimension(440, 160));

        descriptionArea = new JTextArea(6, 36);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        JScrollPane descScroll = new JScrollPane(descriptionArea);
        descScroll.setAlignmentX(Component.LEFT_ALIGNMENT);

        right.add(tableScroll);
        right.add(Box.createVerticalStrut(8));
        right.add(descScroll);
        return right;
    }

    private JPanel buildBottomControls() {
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottom.setBorder(BorderFactory.createTitledBorder("Control Panel"));

        for (SolarSystemStar s : SolarSystemStar.values()) {
            JButton b = new JButton(s.name());
            b.addActionListener(e -> updateSelection(s));
            bottom.add(b);
        }

        bottom.add(new JLabel("  |  "));
        JButton start = new JButton("Start Spin");
        start.addActionListener(e -> startSpinner());
        JButton stop = new JButton("Stop & Choose");
        stop.addActionListener(e -> stopSpinnerAndChoose());
        bottom.add(start);
        bottom.add(stop);

        return bottom;
    }

    private void startSpinner() {
        if (spinner != null && spinner.isRunning()) return;
        spinner = new Timer(120, e -> {
            SolarSystemStar[] vals = SolarSystemStar.values();
            SolarSystemStar s = vals[rng.nextInt(vals.length)];
            bigNameLabel.setText("★ " + s.getDisplayName() + " ★");
        });
        spinner.start();
    }

    private void stopSpinnerAndChoose() {
        if (spinner != null) spinner.stop();
        String txt = bigNameLabel.getText();
        for (SolarSystemStar s : SolarSystemStar.values()) {
            if (txt.contains(s.getDisplayName())) {
                updateSelection(s);
                break;
            }
        }
    }

    private void updateSelection(SolarSystemStar s) {
        selected = s;
        bigNameLabel.setText("★ " + s.getDisplayName() + " ★");
        descriptionArea.setText(s.getDescription());
        chooserBox.setSelectedItem(s);
        int row = s.ordinal();
        if (row >= 0 && row < model.getRowCount()) {
            table.setRowSelectionInterval(row, row);
            table.scrollRectToVisible(table.getCellRect(row, 0, true));
        }
    }
}
