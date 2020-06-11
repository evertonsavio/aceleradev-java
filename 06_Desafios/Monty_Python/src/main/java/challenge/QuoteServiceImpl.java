package challenge;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		return repository.findQuote();
	}

	@Override
	public Quote getQuoteByActor(String actor) {

		List<Quote> quote = (List<Quote>) repository.findByActor(actor);
		Quote quoteAux = new Quote();

		if(!quote.isEmpty()) {
			quoteAux = quote.get(this.getQuoteComValorRandom(quote.size()));

		}else {
			return null;
		}
		return quoteAux;
	}

	private Integer getQuoteComValorRandom(Integer size) {
		Random sorteio = new Random();
		return sorteio.nextInt(size) ;
	}
}