package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información de signos vitales del paciente")
@Entity
@Table(name = "signo_vital")
public class SignoVital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSignoVital;

	@ManyToOne // FK
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signo_paciente"))
	private Paciente paciente;

	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;

	@Min(value=36, message = "Temperatura mínima es 36 °C")
	@Max(value = 42, message = "Temperatura máxima es 42 °C")
	@Column(name = "temperatura", nullable = false) // unique = true
	private Double temperatura;

	@Min(value=60, message = "Pulso mínima es 60 pulsaciones por minuto")
	@Max(value = 150, message = "Pulso mínima es 150 pulsaciones por minuto")
	@Column(name = "pulso", nullable = false)
	private Integer pulso;

	@Min(value=20, message = "Ritmo mínimo es 20 respiraciones por minuto")
	@Max(value=100, message = "Ritmo mínimo es 100 respiraciones por minuto")
	@Column(name = "ritmo_resp", nullable = false)
	private Integer ritmoResp;

	public Integer getIdSignoVital() {return idSignoVital;}
	public void setIdSignoVital(Integer idSignoVital) {this.idSignoVital = idSignoVital;}

	public Paciente getPaciente() {return paciente;}
	public void setPaciente(Paciente paciente) {this.paciente = paciente;}

	public LocalDateTime getFecha() {return fecha;}
	public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}

	public Double getTemperatura() {return temperatura;	}
	public void setTemperatura(Double temperatura) {this.temperatura = temperatura;}

	public Integer getPulso() {return pulso;}
	public void setPulso(Integer pulso) {this.pulso = pulso;}

	public Integer getRitmoResp() {return ritmoResp;}
	public void setRitmoResp(Integer ritmoResp) {this.ritmoResp = ritmoResp;}	
}

	

