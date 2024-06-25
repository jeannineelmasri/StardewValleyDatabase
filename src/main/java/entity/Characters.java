package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Characters {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	 	@Column(name = "names")
	    private String name;
	 
	    @Column(name = "likes")
	    private String likes;

	    @Column(name = "loves")
	    private String loves;

	    @Column(name = "hates")
	    private String hates;
	    
	    @Column(name = "dislikes")
	    private String dislikes;

	    @Column(name = "image") // Add a column for image URLs
	    private String imageUrl;
	    
	    public Characters() {

	    }

	    public Characters(String name, String likes, String loves, String hates, String dislikes, String image_url) {
	    	this.name = name;
	        this.likes = likes;
	        this.loves = loves;
	        this.hates = hates;
	        this.dislikes = dislikes;
	        this.imageUrl = image_url;
	    }

	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNames() {
			return name;
		}

		public void setNames(String names) {
			this.name = names;
		}

		public String getLikes() {
			return likes;
		}

		public void setLikes(String likes) {
			this.likes = likes;
		}

		public String getLoves() {
			return loves;
		}

		public void setLoves(String loves) {
			this.loves = loves;
		}

		public String getHates() {
			return hates;
		}

		public void setHates(String hates) {
			this.hates = hates;
		}

		public String getDislikes() {
			return dislikes;
		}

		public void setDislikes(String dislikes) {
			this.dislikes = dislikes;
		}
		
		public String getImageUrl() {
			return imageUrl;
		}
		
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		@Override
	    public String toString() {
	        return "Character [id=" + id + ", name=" + name + 
	        		", likes=" + likes + 
	        		", loves=" + loves + 
	        		", hates=" + hates +
	        		", dislikes=" + dislikes +
	        		", image= " + imageUrl +
	        		"]";
	    }
	}