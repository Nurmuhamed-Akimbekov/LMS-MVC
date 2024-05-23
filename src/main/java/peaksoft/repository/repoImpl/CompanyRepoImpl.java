package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class CompanyRepoImpl implements CompanyRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCompany(Company company) {
        if (company != null) {
            entityManager.persist(company);
        } else throw new NoSuchElementException("not found");

    }

    @Override
    public Company getById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select c from Company  c", Company.class).getResultList();
    }

    @Override
    public void updateById(Long id, Company newCompany) {
        Company company = getById(id);
        company.setName(newCompany.getName());
        company.setImageLink(newCompany.getImageLink());
        company.setDescription(newCompany.getDescription());
        entityManager.merge(company);
    }

@Override
public void deleteCompanyById(Long id) {
    entityManager.remove(entityManager.find(Company.class, id));
}
}
