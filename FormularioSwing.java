package academy.devdojo.maratonajava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FormularioSwing extends JFrame {

    private JTextField textField;
    private JButton submitButton;
    private JLabel resultLabel;

    public FormularioSwing() {
        // Configuração do frame
        setTitle("Exemplo de Formulário Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);


        textField = new JTextField(10);
        submitButton = new JButton("Enviar");
        resultLabel = new JLabel("Aguardando entrada...");


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        add(new JLabel("Digite um número:"));
        add(textField);
        add(submitButton);
        add(resultLabel);

        // Adicionar evento ao botão
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarEntrada();
            }
        });
    }

    private void processarEntrada() {
        try {
            // Obter valor do campo de texto
            double valor = Double.parseDouble(textField.getText());

            // Verificar condição
            if (valor > 100) {
                resultLabel.setText("Número maior que 100!");
            } else {
                resultLabel.setText("Número menor ou igual a 100.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Por favor, digite um número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioSwing().setVisible(true));
    }


}
