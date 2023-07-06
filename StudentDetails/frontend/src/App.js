import './App.css';
import StudentList from './components/StudentList';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom'

function App() {
  return (
    <div className='App col-sm-10 offset-sm-1'>
    <Router>
    <Routes>
    <Route path ="/" element={<StudentList/>} />
    </Routes>
    </Router>
  </div>
  );
}

export default App;
