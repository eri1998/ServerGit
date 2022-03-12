package com.danilo.sistemskeOperacije;

import com.danilo.konekcija.Konekcija;

public abstract class OpstaSistemskaOperacija {
public void izvrsiSistemskeOperacije(Object object) {
	try {
		pokreniTransakciju();
		izvrsiKonkretnuOperacije(object);
		potvrdiTransakciju();
	} catch (Exception e) {
		ponistiTransakciju();
	}finally {
		zatvoriKonekciju();
	}
	
	
}

private void zatvoriKonekciju() {
	Konekcija.getInstanca().zatvoriKonekciju();
}

private void ponistiTransakciju() {
	Konekcija.getInstanca().ponistiTransakciju();
}

private void potvrdiTransakciju() {
Konekcija.getInstanca().potvrdiTransakciju();
}

protected abstract void izvrsiKonkretnuOperacije(Object object);

private void pokreniTransakciju() {
	Konekcija.getInstanca().pokreniTransakciju();
	
}


}
