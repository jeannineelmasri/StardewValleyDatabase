import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import entity.Character;

public class Window {

    private JFrame frame;
    private Character[] characters;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                    window.initialize();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     *
     * @throws IOException
     */
    public Window() throws IOException {
        characters = Character.readFromFile("characters.json"); 
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setSize(482, 304);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout()); // border layout to add scroll bar

        JLabel lblNewLabel = new JLabel("Stardew Valley");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Harrington", Font.PLAIN, 56)); 
        frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Buttons for each character using for-each loop
        for (Character character : characters) {
            JButton button = new JButton(character.getName());

            //if character has an image in json file...
            String[] imageUrls = character.getData().getImage();
            if (imageUrls != null && imageUrls.length > 0) {
                // Load the image from the image URL
                try {
                    Image image = ImageIO.read(new File(imageUrls[0]));
                    Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    button.setIcon(new ImageIcon(scaledImage)); //sets the image as the icon of the button
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            //when you click button new window with character data displayed
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayCharacterData(character);
                }
            });
            buttonPanel.add(button);
        }

        // Add button panel to scroll pane
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Show horizontal scroll bar

        // Add scroll pane to frame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Display character data in a new window.
     */
    private void displayCharacterData(Character character) {
        JFrame dataFrame = new JFrame();
        dataFrame.setTitle(character.getName() + " Data");
        dataFrame.setBounds(200, 200, 400, 200);
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // panel to hold character data
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); 
        // character data such as Likes, Loves, Hates, Dislikes displayed on Character Data window
        panel.add(new JLabel("Likes: " + String.join(", ", character.getData().getLikes())));
        panel.add(new JLabel("Loves: " + String.join(", ", character.getData().getLoves())));
        panel.add(new JLabel("Hates: " + String.join(", ", character.getData().getHates())));
        panel.add(new JLabel("Dislikes: " + String.join(", ", character.getData().getDislikes())));

        dataFrame.getContentPane().add(panel);
        dataFrame.setVisible(true);
    }
}
