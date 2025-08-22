import React, { Component } from "react"; // Import React and Component base class
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap styles

class MovieForm extends Component { // Define MovieForm class component
  constructor(props) { // Constructor for initialization
    super(props); // Call parent constructor
    console.log("constructor executed"); // Log constructor execution
    this.state = { // Initialize component state
      title: "", // Movie title input
      director: "", // Director input
      year: "", // Release year input
      genre: "Action", // Default genre
      rating: "", // Rating input
      description: "", // Description input
      platforms: { // Platforms checkbox state
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
      movies: [], // Store list of added movies
    };
  }

  static getDerivedStateFromProps(nextProps, prevState) { // Lifecycle: sync state with props
    console.log("getDerivedStateFromProps executed"); // Log execution
    return null; // No changes to state from props
  }

  componentDidMount() { // Lifecycle: runs after component mounts
    console.log("componentDidMount executed"); // Log mount
  }

  shouldComponentUpdate(nextProps, nextState) { // Lifecycle: decide if re-render is needed
    console.log("shouldComponentUpdate executed"); // Log execution
    return true; // Always allow updates
  }

  getSnapshotBeforeUpdate(prevProps, prevState) { // Lifecycle: capture info before update
    console.log("getSnapshotBeforeUpdate executed"); // Log execution
    return null; // No snapshot needed
  }

  componentDidUpdate(prevProps, prevState, snapshot) { // Lifecycle: runs after update
    console.log("componentDidUpdate executed"); // Log execution
  }

  componentWillUnmount() { // Lifecycle: runs before component unmount
    console.log("componentWillUnmount executed"); // Log unmount
  }

  handleChange = (e) => { // Handle form input changes
    const { name, value, type, checked } = e.target; // Destructure input properties

    if (type === "checkbox") { // If input is checkbox
      this.setState((prevState) => ({ // Update nested platforms state
        platforms: {
          ...prevState.platforms, // Keep previous platform values
          [name]: checked, // Update only current checkbox
        },
      }));
    } else { // For other input types
      this.setState({ [name]: value }); // Update state directly
    }
  };

  handleSubmit = (e) => { // Handle form submit
    e.preventDefault(); // Prevent page reload
    const { title, director, year, genre, rating, description, platforms } =
      this.state; // Extract values from state

    const selectedPlatforms = Object.keys(platforms).filter( // Filter checked platforms
      (key) => platforms[key]
    );

    const newMovie = { // Create new movie object
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms: selectedPlatforms.join(", "), // Join selected platforms as string
    };

    this.setState((prevState) => ({ // Update movies list and reset form
      movies: [...prevState.movies, newMovie], // Add new movie to list
      title: "", // Reset title
      director: "", // Reset director
      year: "", // Reset year
      genre: "Action", // Reset genre to default
      rating: "", // Reset rating
      description: "", // Reset description
      platforms: { // Reset platforms
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
    }));
  };

  render() { // Render method
    console.log("render executed"); // Log render call

    return (
      <div className="container mt-4"> {/* Main container */}
        <div className="card p-3 shadow-sm"> {/* Card wrapper */}
          <h4 className="mb-3">Add Movie</h4> {/* Form heading */}
          <form onSubmit={this.handleSubmit}> {/* Form with submit handler */}
            <div className="mb-2">
              <label>Movie Title</label>
              <input
                type="text" // Title input
                className="form-control"
                name="title"
                value={this.state.title} // Controlled input value
                onChange={this.handleChange} // Update state on change
                required // Mandatory field
              />
            </div>

            <div className="mb-2">
              <label>Director</label>
              <input
                type="text" // Director input
                className="form-control"
                name="director"
                value={this.state.director}
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="mb-2">
              <label>Release Year</label>
              <input
                type="number" // Year input
                className="form-control"
                name="year"
                value={this.state.year}
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="mb-2">
              <label>Genre</label>
              <select
                className="form-control" // Genre dropdown
                name="genre"
                value={this.state.genre}
                onChange={this.handleChange}
              >
                <option>Action</option> {/* Options for genre */}
                <option>Comedy</option>
                <option>Drama</option>
                <option>Sci-Fi</option>
                <option>Horror</option>
              </select>
            </div>

            <div className="mb-2">
              <label>Rating</label> <br />
              {[1, 2, 3, 4, 5].map((num) => ( // Map through rating options
                <span key={num} className="me-2">
                  <input
                    type="radio" // Radio button for rating
                    name="rating"
                    value={num}
                    checked={this.state.rating === String(num)} // Check selected rating
                    onChange={this.handleChange}
                    className="form-check-input me-1"
                  />
                  {num} {/* Display rating number */}
                </span>
              ))}
            </div>

            <div className="mb-2">
              <label>Description</label>
              <textarea
                className="form-control" // Textarea for description
                name="description"
                value={this.state.description}
                onChange={this.handleChange}
              ></textarea>
            </div>

            <div className="mb-2">
              <label>Available on Streaming Platforms</label> <br />
              {Object.keys(this.state.platforms).map((platform) => ( // Map through platforms
                <span key={platform} className="me-3">
                  <input
                    type="checkbox" // Checkbox input
                    name={platform}
                    checked={this.state.platforms[platform]} // Controlled checkbox
                    onChange={this.handleChange}
                    className="form-check-input me-1"
                  />
                  {platform} {/* Platform name */}
                </span>
              ))}
            </div>

            <button type="submit" className="btn btn-primary"> {/* Submit button */}
              Add Movie
            </button>
          </form>
        </div>

        {this.state.movies.length > 0 && ( // Show movie table if movies exist
          <div className="mt-4">
            <table className="table table-bordered"> {/* Movies table */}
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Release Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Available on Platforms</th>
                </tr>
              </thead>
              <tbody>
                {this.state.movies.map((movie, index) => ( // Map through movies
                  <tr key={index}>
                    <td>{movie.title}</td>
                    <td>{movie.director}</td>
                    <td>{movie.year}</td>
                    <td>{movie.genre}</td>
                    <td>{movie.rating}</td>
                    <td>{movie.platforms}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default MovieForm; // Export component for use
