import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JButton;

public class Display extends JFrame {

	private JPanel contentPane;
	public Pokemon choice;
	public Pokemon comp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(112, 23, 211, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Please choose your Pokemon!");

		final JTextArea statsDisplay = new JTextArea();
		JScrollPane statScroll = new JScrollPane(statsDisplay);
		statScroll.setBounds(112, 54, 211, 162);
		contentPane.add(statScroll);

		Connect.listAll(comboBox);

		final JButton select = new JButton("Choose this Pokemon");
		select.setEnabled(false);
		select.setBounds(112, 227, 211, 36);
		contentPane.add(select);

		final JButton battleBtn = new JButton("Begin Battle!");
		battleBtn.setEnabled(false);
		battleBtn.setVisible(false);
		battleBtn.setBounds(112, 227, 211, 36);
		contentPane.add(battleBtn);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice = Connect.getPokemon(comboBox);
				statsDisplay.setText(null);
				statsDisplay.setText(choice.toString());
				select.setEnabled(true);
			}
		});

		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comp = Connect.getComp(comboBox);
				statsDisplay.setText(null);
				statsDisplay.setText("The computer chooses:\n\n"
						+ comp.toString());
				select.setEnabled(false);
				select.setVisible(false);
				battleBtn.setEnabled(true);
				battleBtn.setVisible(true);
			}
		});

		battleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				battle(choice, comp, statsDisplay);
				battleBtn.setEnabled(false);
			}
		});
	}

	public void battle(Pokemon attack, Pokemon defend, JTextArea display) {
		display.setText(null);
		int attackHP = attack.getHp();
		int defendHP = defend.getHp();
		int dmg = 0;
		while (attackHP > 0 && defendHP > 0) {
			if (attack.getSpd() >= defend.getSpd()) {
				dmg = attack.getAtk() - defend.getDef();
				if (dmg < 0) {
					dmg = 1;
				}
				defendHP -= dmg;
				display.setText(display.getText() + "\n" + defend.getName()
						+ " took " + dmg + " damage!");
				dmg = defend.getAtk() - attack.getDef();
				if (dmg < 0) {
					dmg = 1;
				}
				attackHP -= dmg;
				display.setText(display.getText() + "\n" + attack.getName()
						+ " took " + dmg + " damage!");

			} else {
				dmg = defend.getAtk() - attack.getDef();
				if (dmg < 0) {
					dmg = 1;
				}
				attackHP -= dmg;
				display.setText(display.getText() + "\n" + attack.getName()
						+ " took " + dmg + " damage!");
				dmg = attack.getAtk() - defend.getDef();
				if (dmg < 0) {
					dmg = 1;
				}
				defendHP -= dmg;
				display.setText(display.getText() + "\n" + defend.getName()
						+ " took " + dmg + " damage!");
			}
		}
		if (attackHP <= 0) {
			display.setText(display.getText() + "\n" + attack.getName()
					+ " fainted! The computer wins!");
		} else if (defendHP <= 0) {
			display.setText(display.getText() + "\n" + defend.getName()
					+ " fainted! You win!");
		}
	}
}
