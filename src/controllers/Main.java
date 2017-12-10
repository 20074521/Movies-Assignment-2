package controllers;

import java.io.File;
import java.io.IOException;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import model.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main implements ShellDependent {
	private static final String ADMIN = "admin";
	public MoviesAPI moApi  = new MoviesAPI();
	private Shell theShell;

	
	public MoviesInterFace movie;
	
	public Main() throws Exception {
		File datastore = new File("datastore.xml");
		Serializer serializer = new XMLSerializer(datastore);
		moApi = new MoviesAPI(serializer);
		if (datastore.isFile()) {
			moApi.load();
		}
	}

	public void cliSetShell(Shell theShell) {
		this.theShell = theShell;
	}

	@Command(description = "Log in")
	public void logIn(@Param(name = "user Id") Long UserId, @Param(name = "Last name") String lName)
			throws IOException {

		if (moApi.login(UserId, lName) && moApi.currentUser.isPresent()) {
			User user = moApi.currentUser.get();
			System.out.println("You are logged in as " + user.fName);
			if (user.role != null && user.role.equals(ADMIN)) {
				AdminMenu adminMenu = new AdminMenu(moApi, user.fName);
				ShellFactory.createSubshell(user.fName, theShell, "Admin", adminMenu).commandLoop();
			} else {
				DefaultMenu defaultMenu = new DefaultMenu(moApi, user);
				ShellFactory.createSubshell(user.fName, theShell, "Default", defaultMenu).commandLoop();
			}
		} else
			System.out.println("Unknown username/password.");
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.moApi.initalLoad();
		Shell shell = ShellFactory.createConsoleShell("pm", "Welcome to Movies-console - ?help for instructions",main);
		shell.commandLoop();
		main.moApi.store();
	}
}
