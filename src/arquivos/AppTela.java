package arquivos;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import ui.FrameTela;

public class AppTela {

	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
			UIManager.setLookAndFeel(info.getClassName());
			break;
			}
			}
			} catch (UnsupportedLookAndFeelException e) {
			// handle exception
			} catch (ClassNotFoundException e) {
			// handle exception
			} catch (InstantiationException e) {
			// handle exception
			} catch (IllegalAccessException e) {
			// handle exception
			}
		
		FrameTela telaCliente = new FrameTela();
		telaCliente.criarTela();

	}
	
}
