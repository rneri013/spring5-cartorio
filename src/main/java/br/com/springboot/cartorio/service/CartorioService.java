package br.com.springboot.cartorio.service;

import br.com.springboot.cartorio.model.Cartorio;
import br.com.springboot.cartorio.repository.CartorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartorioService {

    private CartorioRepository repository;

    @Autowired
    public CartorioService(CartorioRepository repository) {
        this.repository = repository;
    }

    public List<Cartorio> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Cartorio> findById(Long id) {
        return repository.findById(id);
    }

    public Cartorio save(Cartorio stock) {
        return repository.save(stock);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
