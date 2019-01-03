package app;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import model.IPessoa;
import model.Pessoa;

@Component
public class CachePessoa implements IPessoa {

	@Cacheable("pessoa")
	public Pessoa getPessoa(String nome, int idade) {
		sleepPessoa();
		return new Pessoa(nome, idade);
	}

	public void sleepPessoa() {
		try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
	}

}