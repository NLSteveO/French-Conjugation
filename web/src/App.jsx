import { Component } from 'react';
import { generate, generateIrregularVerb, generateSubjectPronoun } from './WordBank.js';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      subjectPronoun: 'subjectPronoun',
      irregularVerb: 'irregularVerb',
      answer: 'answer',
      showAnswer: false,
      answerToCheck: '',
      answerToShow: ''
    };
  }

  componentDidMount() {
    this.generatePhrase();
  };

  generatePhrase = () => {
    this.hideAnswer();
    const { subjectPronoun, irregularVerb, answer } = generate();
    this.setState({ subjectPronoun, irregularVerb, answer });
  };

  generateNewSubjectPronoun = () => {
    this.hideAnswer();
    this.setState(({irregularVerb}) => generateSubjectPronoun(irregularVerb));
  };

  generateNewIrregularVerb = () => {
    this.hideAnswer();
    this.setState(({subjectPronoun}) => generateIrregularVerb(subjectPronoun));
  };

  showAnswerOnPress = () => this.setState(({ answer }) => ({ showAnswer: true, answerToShow: answer }));

  hideAnswer = () => this.setState({ showAnswer: false });

  inputOnChange = evt => this.setState({ answerToCheck: evt.target.value });

  checkAnswer = () => {
    const { answer, answerToCheck, showAnswer } = this.state;
    if (answer.toLowerCase() === answerToCheck.toLowerCase()) {
      this.setState({ answerToShow: 'Correct!', showAnswer: true });
    }
    else {
      this.setState({ answerToShow: 'Incorrect!', showAnswer: true });
    }
  }

  render() {
    const { subjectPronoun, irregularVerb, answerToShow, showAnswer } = this.state;
    return (
      <div className='basis-1/2 flex-col justify-center rounded-2xl p-2 bg-gray-800'>
        <div className='p-2'>
          <button className='basis-full border-black border rounded-lg bg-gray-300' type='button' onClick={this.generatePhrase}>Generate Phrase</button>
        </div>
        <div className='justify-evenly'>
          <div className='flex-col basis-1/4 space-y-2'>
            <label className='bg-gray-100 text-center'>{subjectPronoun}</label>
            <button className='border-black border rounded-lg bg-gray-300' type='button' onClick={this.generateNewSubjectPronoun}>Generate</button>
          </div>
          <div className='flex-col basis-1/4 space-y-2'>
            <label className='bg-gray-100 text-center'>{irregularVerb}</label>
            <button className='border-black border rounded-lg bg-gray-300' type='button' onClick={this.generateNewIrregularVerb}>Generate</button>
          </div>
          <div className='flex-col basis-1/4 space-y-2'>
            <input className='bg-gray-100 text-center' autoFocus onChange={this.inputOnChange} />
            <button className='border-black border rounded-lg bg-gray-300' type='button' onClick={this.checkAnswer}>Check</button>
          </div>
        </div>
        <div className='flex-col space-y-2 p-2'>
          <label className='basis-full bg-gray-100 text-center'>{showAnswer ? answerToShow : ''}</label>
          <button className='basis-full border-black border rounded-lg bg-gray-300' type='button' onClick={this.showAnswerOnPress}>Show Answer</button>
        </div>
      </div>
    );
  };
};

export default App
