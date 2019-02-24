package com.ron.hr;


import org.springframework.data.jpa.repository.JpaRepository;

interface HRDAO extends JpaRepository<Associate, Long> {
   
}