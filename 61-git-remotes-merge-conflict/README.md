# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test newfolder
2. Ci si assicuri di avere localmente entrambi i branch remoti
git branch -r
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master` e da qui si esegua il merge di `feature`
git checkout master (sposto la testa su master)
git pull origin master (Questo scarica eventuali aggiornamenti dal repository remoto, evitando conflitti)
git merge origin/feature
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

     git log --graph --all
6. Si crei un nuovo repository nel proprio github personale
    dal sito di github
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
   git remote add source https://github.com/larck9/test00.git 
8. Si faccia push del branch `master` sul proprio repository
   git push remote master
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
git branch --set-upstream-to=source/master master
git status




git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master
  remotes/source/master
PS C:\Users\Lorenzo\Desktop\programmazioneaoggetti\es lab\oop-lab06\61-git-remotes-merge-conflict\newfolder> git remote -v
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)
source  https://github.com/larck9/test00.git (fetch)
source  https://github.com/larck9/test00.git (push)
PS C:\Users\Lorenzo\Desktop\programmazioneaoggetti\es lab\oop-lab06\61-git-remotes-merge-conflict\newfolder> git fetch source
PS C:\Users\Lorenzo\Desktop\programmazioneaoggetti\es lab\oop-lab06\61-git-remotes-merge-conflict\newfolder> git branch -r   
  origin/HEAD -> origin/master
  origin/feature
  origin/master
  source/HEAD -> source/master
  source/master