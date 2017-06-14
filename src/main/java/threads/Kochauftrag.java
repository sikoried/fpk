package threads;

class Kochauftrag {
	String name;
	int schritte;

	Kochauftrag(String name, int schritte) {
		this.name = name;
		this.schritte = schritte;
	}

	void kochen() {
		for (int i = 0; i < schritte; i++) {
			System.out.println(name + ": " + i);
		}

		System.out.println(name + " ist fertig!");
	}
}
