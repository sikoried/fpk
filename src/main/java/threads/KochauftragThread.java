package threads;

class KochauftragThread extends Thread {
	String name;
	int schritte;

	KochauftragThread(String name, int schritte) {
		this.name = name;
		this.schritte = schritte;
	}

	@Override
	public void run() {
		for (int i = 0; i < schritte; i++) {
			System.out.println(name + ": " + i);
		}

		System.out.println(name + " ist fertig!");
	}
}
