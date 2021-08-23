package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {

		Participant participant = new Participant();
		participant.setId(1);
		participant.setName("Petro");
		participant.setEmail("perto@mail.com");
		participant.setLevel(Level.L1);
		participant.setPrimarySkill("rest");

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Ivan");
		participant2.setEmail("ivan@mail.com");
		participant2.setLevel(Level.L3);
		participant2.setPrimarySkill("work");

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Stepan");
		participant3.setEmail("stepan@mail.com");
		participant3.setLevel(Level.L5);
		participant3.setPrimarySkill("work hard");

		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Fil");
		participant4.setEmail("fil@mail.com");
		participant4.setLevel(Level.L2);
		participant4.setPrimarySkill("work lazy");

		participants.add(participant);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);
	}

	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
//		update

		if (participant.getId() != null) {
			Participant participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());;
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			
			participants.set(participantIndex, participantToUpdate);
		} else {
//			save
			participant.setId(participants.size()+1);
			participants.add(participant);
		}

	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}
