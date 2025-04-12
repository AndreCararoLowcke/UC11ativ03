public class Main {
    public static void main(String[] args) {
        // Garante que a GUI será criada na thread correta
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new cadastroVIEW().setVisible(true);
            }
        });
    }
}
