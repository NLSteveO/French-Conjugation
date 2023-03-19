import { subjectPronouns, irregularVerbs } from '../constants/index.js';

const subjectPronounsList = subjectPronouns();
const irregularVerbsList = irregularVerbs();

const getRandomWordFromList = list => list[Math.floor(Math.random() * list.length)];

const getRandomSubjectPronoun = () => {
  const subjectPronoun = getRandomWordFromList(subjectPronounsList);
  const subjectPronounIndex = subjectPronounsList.indexOf(subjectPronoun);
  return [subjectPronoun, subjectPronounIndex];
}

const getRandomIrregularVerb = () => getRandomWordFromList(Object.keys(irregularVerbsList));

const getAnswer = (subjectPronounIndex, verbsList) => verbsList[subjectPronounIndex];

export const generate = () => {
  const [subjectPronoun, index] = getRandomSubjectPronoun();
  const irregularVerb = getRandomIrregularVerb();
  const answer = getAnswer(index, irregularVerbsList[irregularVerb]);
  return { subjectPronoun, irregularVerb, answer };
};

export const generateSubjectPronoun = irregularVerb => {
  const [subjectPronoun, index] = getRandomSubjectPronoun();
  const answer = getAnswer(index, irregularVerbsList[irregularVerb]);
  return { subjectPronoun, answer };
};

export const generateIrregularVerb = subjectPronoun => {
  const irregularVerb = getRandomIrregularVerb();
  const index = subjectPronounsList.indexOf(subjectPronoun);
  const answer = getAnswer(index, irregularVerbsList[irregularVerb]);
  return { irregularVerb, answer };
};
