package com.os.os.Repository;

import com.os.os.Domain.Cliente;
import com.os.os.Domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
