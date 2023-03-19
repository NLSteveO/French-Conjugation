const fs = require('fs');
const path = require('path');

/**
 * This little script was written to take the word files in lib directory in the root
 * and print them out line by line in a json friendly format so i could copy and paste
 * them into JS functions to be exported like a constant to access in the front end.
 *
 * Run from this files directory with node and pass in the path to the file you want converted.
 * Ex. node convert.js ../../lib/irr
 */

const convert = file => {
  const fileObject = {};
  file.forEach(line => {
    if (line.length <= 0) return;
    const [key, csv] = line.split('-');
    let list = '[ ';
    const splitCSV = csv.split(',');
    splitCSV.forEach((word, index) => {
      if (index === 0) list = list.concat(`"${word}"`);
      else list = list.concat(', ', `"${word}"`);
    });
    list = list.concat(' ',  '],');
    console.log(`"${key}": ${list}`);
    fileObject[key] = list;
  });
}

const getFile = fileName => {
  const filePath = path.join(__dirname, fileName);
   fs.readFile(filePath, {encoding: 'utf-8'}, (err, data) => {
    if (!err) {
      convert(data.split('\n'));
    } else {
      console.error(err);
      return;
    }
  });
}

getFile(process.argv[2]);
