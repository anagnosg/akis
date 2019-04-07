package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.ScoreDB;
import gr.akis.handsapp.db.UserDB;
import gr.akis.handsapp.exceptions.BusinessException;
import gr.akis.handsapp.models.Score.Requests.AssignScoreRequest;
import gr.akis.handsapp.models.Score.Requests.DeleteScoreRequest;
import gr.akis.handsapp.models.Score.Responses.Score;
import gr.akis.handsapp.models.User.Token;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class ScoreBs {
	@Inject
	ConnectionWrapper connwrap;

	@Inject
	ScoreDB vathmologiaDB;
	@Inject
	UserDB userDB;

	public List<Score> selectAll() throws SQLException {
		List<Score> vathmologia;
		vathmologia = vathmologiaDB.selectAll();
		return vathmologia;
	}
	
	public List<Score> select(Integer venueId) throws SQLException {
		List<Score> vathmologia;
		vathmologia = vathmologiaDB.select(venueId);
		return vathmologia;
	}
	
	public Score insert(AssignScoreRequest request) throws SQLException,BusinessException {
		Token t = userDB.selectToken(request.getToken());
		if(t==null) {
			
			throw new BusinessException("Παρακαλώ συνδεθείτε στο σύστημα");
		}
		Score s = new Score();
		s.setUserId(t.getUserId());
		s.setScore(request.getScore());
		s.setComment(request.getComment());
		s.setVenueId(request.getVenueId());
		
		return vathmologiaDB.insert(s);
	}

	public void delete(DeleteScoreRequest request) throws SQLException,BusinessException {
		Token t = userDB.selectToken(request.getToken());
		if(t==null) {
			
			throw new BusinessException("Παρακαλώ συνδεθείτε στο σύστημα");
		}
		vathmologiaDB.delete(t.getUserId(),request.getVenueId());
	}
}
