CREATE FUNCTION scarefunc() RETURNS trigger AS $$
	DECLARE
		cave_id integer = 1;
		scare_id integer = 1;
	BEGIN
		CASE WHEN NEW.location_id = cave_id THEN 
			INSERT INTO feel_emotions (pitecantrop_id, emotion_id) 
				VALUES (NEW.id, scare_id);
			RETURN NEW;	
		ELSE DELETE FROM feel_emotions WHERE pitecantrop.id = NEW.id AND emotion.id = scare_id;
			Return NEW;
	End Case;
	END;
$$LANGUAGE plpgsql;

create trigger pitec_trigger
after insert or update of location_id on pitecantrop
for each row execute procedure scarefunc();